ImageView view = (ImageView)findViewById(R.id.imageView1);

switch (getIntent().getIntExtra ("clicked_position", -1))
{
  case 0:
    view.setImageResouce (R.drawable.x);
    break;
  case 1:
     view.setImageResouce (R.drawable.y);
     break;
  default:
     view.setImageResouce (R.drawable.default);
}