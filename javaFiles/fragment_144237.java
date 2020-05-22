OnItemClickListener itemClicked = new OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            Log.d("fragment", "clicked!!" + parent.getItemAtPosition(position).toString());
            startActivity(new Intent(getActivity(), OrderActivity.class));
        }
    };