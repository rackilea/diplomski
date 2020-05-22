for (int i = 0; i < thingslist.size(); i++) {
        Things thing = thingslist.get(i);
        googleMaps.addMarker(new MarkerOptions()
                .position(new LatLng(Double.valueOf(thing.getLatitude()), Double.valueOf(thing.getLongitude())))
                .snippet(thing.getDescricao())
                .icon(BitmapDescriptorFactory.fromResource(MudancaIconeMarker(thing.getTipo())))
                .title(thing.getName()))
                .setTag(String.valueOf(i));

    }

    googleMaps.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            Intent intent = new Intent(getActivity(), ActivityDetails.class);
            int index=Integer.valueOf(marker.getTag());
            ActivityDetails.Info.id = marker.getId();
            ActivityDetails.Info.photoURL =thingslist.get(index).getPhoto(); 

            TabInfos.name = marker.getTitle();
            TabInfos.id = marker.getId();
            TabInfos.description = marker.getSnippet();
            TabInfos.time = thingslist.get(index).getTime();

            for (int i = 0;i<24;i++ ){
                if (marker.getId().equals("m"+i)){ ActivityDetails.Info.num=i;TabInfos.num=i;}
            }
            TabMap.this.startActivity(intent);
        }
    });