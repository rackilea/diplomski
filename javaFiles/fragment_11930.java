mListView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {

            // TODO Auto-generated method stub
            TextView tv1 = (TextView) view.findViewById(R.id.tv_id);
            TextView tv2 = (TextView) view.findViewById(R.id.tv_country_details);
            String genus = (String) tv1.getText().toString();
            String genus2 = (String) tv2.getText().toString();

            Toast.makeText(getBaseContext(),genus+"--"+id+" "+genus2 , Toast.LENGTH_SHORT).show();
        }
    });

    return adapter;
}