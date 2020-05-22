gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        {
            IMAGES = imagesPath[0] + "|" + imagesPath[1] + "|" + imagesPath[2] + "|" +
                        imagesPath[3] + "|" + imagesPath[4] + "|" + imagesPath[5];

            Intent intent = new Intent(AddClientActivity.this, ImageViewActivity.class);
            intent.putExtra("IMAGES", IMAGES);
            intent.putExtra("POSITION", position);
            startActivity(intent);
        }
    });