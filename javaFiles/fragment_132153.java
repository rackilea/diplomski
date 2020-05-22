public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
            @Override
            public View getInfoWindow(Marker arg0) {

                for (CityObject cityObject : cityObjects){
                    if (arg0.getTitle().equals(cityObject.getName())){
                        View v = getActivity().getLayoutInflater().inflate(R.layout.layout_info_window, null);
                        Button info = (Button) v.findViewById(R.id.infoButton);
                        info.setText(cityObject.getName());
                        BitmapLayout back = (BitmapLayout) v.findViewById(R.id.bitmapBackground);
                        Picasso.with(getContext()).load(cityObject.getImgs().get(0)).into(back);
                        return v;
                    }
                }
                return null;
            }

            @Override
            public View getInfoContents(Marker arg0) {

                return null;
            }
    }