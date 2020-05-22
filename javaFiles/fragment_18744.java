@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.your_menu_res, menu);
    MenuItem item = menu.findItem(R.id.crop_image_menu_crop);
    item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    ...
}