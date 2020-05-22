mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                pos =position;
                Intent intent = new Intent(MainActivity.this, CorrespondingActivity.class);
                startActivity(intent);


                switch (position) {
                    default:


                }

        }

});