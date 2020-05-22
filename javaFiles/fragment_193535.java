TextView tvFullName = (TextView)findViewById(R.id.name);
TextView tvEmail = (TextView)findViewById(R.id.email);
ImageView imgProfile = (ImageView)findViewById(R.id.imgProfile);

tvFullName.setText(userInfo[0] + " " + userInfo[1]);
tvEmail.setText(userInfo[2]);