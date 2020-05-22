protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK)
    {
        if(requestCode == PICK_IMAGE_MULTIPLE)
        {
            if (adapter != null)
            {
                adapter.clear();
                adapter = new ImageAdapter(this, R.id.grdImages, items);
                gridView.setAdapter(adapter);
            }

            imagesPath = data.getStringExtra("data").split("\\|");

            for (int i=0; i<imagesPath.length; i++)
            {
                bitmap = BitmapFactory.decodeFile(imagesPath[i]);
                items.add(bitmap);
            }

            adapter = new ImageAdapter(this, R.id.grdImages, items);
            gridView.setAdapter(adapter);
        }
    }
}