// ...
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
        CatalogDatabase cd = dataSnapshot.getValue(CatalogDatabase.class);
        list.add(cd);
    }
    adapter.notifyDataSetChanged();
}
// ...