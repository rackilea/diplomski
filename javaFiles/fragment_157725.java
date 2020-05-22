GridView gridView = (GridView) findViewById(R.id.gridview);
    gridView.setAdapter(new ImageAdapter(this));
    final Integer[] imageIDs = this.getImageIDs();

    gridView.setOnItemClickListener(new OnItemClickListener() 
    {
        public void onItemClick(AdapterView<?> parent, 
        View v, int position, long id) 
        {   
            for (Integer imageId : imageIDs){
                System.out.println(imageId );
            }
        }
    });