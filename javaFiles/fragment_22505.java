private void passText(){
    //Log.i(TAG, "PassText");
    Intent intent = new Intent(this, RegexOCR1.class);
    intent.putExtra("TEXT", "your text here");
    startActivity(intent);
}