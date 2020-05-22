if ("N".equals(items[item]))
{
    Intent intent = new Intent();
    Intent i0 = new Intent(Brain.this, CropImageActivity.class);
    startActivity(i0);
}
else if ("M".equals(items[item]))
{
    Intent intent = new Intent();
    Intent i2 = new Intent(Brain.this, Test2.class);
    startActivity(i2);
}