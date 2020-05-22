mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            GridLayoutManager mGridLayoutManager = new 
            GridLayoutManager(MainActivity.this, 2);
            mRecyclerView.setLayoutManager(mGridLayoutManager);
            mRecyclerView.setAdapter(myMoviesAdapter);
            myMoviesAdapter.setOnItemClickListener(MainActivity.this);