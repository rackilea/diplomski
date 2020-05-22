listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(getApplicationContext(),ArticleActivity.class);
                intent.putExtra("description","whatever data you want to pass");
                startActivity(intent);

            }
        });