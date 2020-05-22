@Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setHasOptionsMenu is important 
            //it's telling the parent activity that he wants to participate in inflation of the menu
            setHasOptionsMenu(true);
        }



        //Rest of your methods (onCreateView, onPause, onResume etc...)


        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            //inflate the menu file
            inflater.inflate(R.menu.your_menu_xml, menu);
            super.onCreateOptionsMenu(menu, inflater);
        }

        @Override
        public boolean onOptionsItemSelected(android.view.MenuItem item) {

            switch (item.getItemId()) {

                case R.id.refresh:
                    //handle click
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }