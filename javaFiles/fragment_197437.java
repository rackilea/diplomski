@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot band : dataSnapshot.getChildren()) {
        String bandName = band.child("Name").getValue(String.class);
        bandsList.add(bandName); 
        System.out.println("bandsList :" + bandsList);
    }
    bandsAdapter.notifyDataSetChanged();
}