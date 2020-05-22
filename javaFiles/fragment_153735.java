mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(getFragmentContainerId(),fragment)
                        .commit();
            }
        });