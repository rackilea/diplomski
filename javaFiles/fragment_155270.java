private void startAdapter(){
    RecyclerView recyclerView = findViewById(R.id.recyclerViewen);
    LastCallAdapter lastCallAdapter = new LastCallAdapter(this, phoneNumbers);
    recyclerView.setAdapter(lastCallAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

}