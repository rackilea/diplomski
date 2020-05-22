getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View v, int pos, long l) {
            switch (pos) {
                case 0:
                    getParentFragment().getChildFragmentManager().beginTransaction().replace(R.id.fragment_container_root_view, new SecondFragment()).addToBackStack("").commit();

                    break;
                case 1:

                    break;

            }

        }
    });