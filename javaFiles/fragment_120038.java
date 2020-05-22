Toolbar toolbar=findViewById(R.id.tool_bar_id);
        SearchView searchView=findViewById(R.id.search_id);
        toolbar.setOnClickListener(v -> {
            searchView.setIconified(false);

        });