ImageButton inherits from ImageView and has its own properties compared to Button properties.

you can check properties here,
http://developer.android.com/reference/android/widget/ImageButton.html

Make your activity implement OnClickListener, then in OnCreate() or after that event. use ,

ImageButton btn = new ImageButton(this); or 
//ImageButton btn = (ImageButton) findViewById(R.id.imgbtnid)
btn.setOnClickListener(this);
in onClick() function you can handle the click event