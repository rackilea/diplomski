String title="hello";
SpannableString ss1=  new SpannableString(title);
    ss1.setSpan(new MyClickableSpan(title), 0, ss1.length(), 0); 
    tv = (TextView) findViewById(R.id.textview);
    tv.setText(ss1);
    tv.setMovementMethod(LinkMovementMethod.getInstance());