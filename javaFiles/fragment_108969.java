searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            ArrayList<MyJobsModel> filteredData = new ArrayList<MyJobsModel>();

            for (MyJobsModel myJobsModel : data) {
                if (myJobsModel.getName().equals(query)) {

                    filteredData.add(myJobsModel);

                }

            }

  adapter = new MyJobsAdapter(data, getContext());
                    recyclerView.setAdapter(adapter);
            return true ;


        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    });