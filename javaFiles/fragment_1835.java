String[] pics = new String[6];

// Fill it like this
for(int i=0; i<pics.length; i++) {
  pics[i] = Constants.BASE_URL+"/bg/a/A" + (i+1) + ".jpg";
}

// To traverse it
for(String picName : pics) {
   // picName contains the name
}