gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


           ParseObject todo = urgentTodosAdapter.getItem(position);

           //get the ParseFile here and then get the url in a string
           ParseFile image = todo.getParseFile("image"); //getParseFile() is a method of ParseObject
           String imageUrl = image.getUrl();

           String about = todo.getString("comment");


            Intent intent = new Intent("com.package.name.DetailsActivity");
            intent.putExtra("about",about);
            intent.putExtra("image",imageUrl); //pass along imageUrl
            startActivity(intent);

        }

    });