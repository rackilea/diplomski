private void setUpRecyclerView(){

    Query query =   db.collection("Users").document("Teachers").collection("Id")
            .whereEqualTo("city" , userCity);

    FirestoreRecyclerOptions < TeacherOfSubject > options = new FirestoreRecyclerOptions.Builder<TeacherOfSubject>()
            .setQuery(query, TeacherOfSubject.class)
            .build();

    teacherAdapter = new TeacherAdapter(options);

    RecyclerView recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(true);    //for performane reasons
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(teacherAdapter);
    teacherAdapter.startListening();

}

@Override
protected void onStart() {
    super.onStart();
}