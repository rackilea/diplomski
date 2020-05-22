recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        items=new ArrayList<>();   // **Add data to list after initialization**
        recyclerView.setLayoutManager(llm);

        recyclerView.setHasFixedSize(true);

        initRecyclerAdapter();

        ImageButton fab = (ImageButton) findViewById(R.id.imgbtn_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NewTimeTable.class);
                startActivity(i);
            }
        });