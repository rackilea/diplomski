Pattern pattern = Pattern.compile("[^\w]");

Matcher matcher = pattern.matcher("testTest");

if (matcher.find()){
    tv.setText("false");
}
else{
    tv.setText("true");
}