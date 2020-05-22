GridView gridView = (GridView) findViewById(R.id.gridview);
    gridView.setAdapter(new ImageAdapter(this));

    gridView.setOnItemClickListener(new OnItemClickListener() 
    {
        public void onItemClick(AdapterView<?> parent, 
        View v, int position, long id) 
        {   
             //Integer[] imageIDs = this.getImageIDs();
            // clicked picture here
            Integer[] imageIDs = this.getImageIDs();
            //Toast.makeText(getBaseContext(),"pic" + (position + 1) + " selected",Toast.LENGTH_SHORT).show();
            //Integer[] imageIDs = ImageAdapter.this.getImageIDs();
            //for (Integer imageId : ImageAdapter.getImageIDs()){
                //  System.out.println(imageId );
                //}
        }
    });