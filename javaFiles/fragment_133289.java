public String randomFactClicked(View view) 
{
  String message = randomFactGenerator();

  ImageView imageView = (ImageView) view;
  imageView.setContentDescription(message);

  return message;
}