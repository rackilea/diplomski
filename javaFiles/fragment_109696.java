@Override
protected void onPostExecute(String s) {
   super.onPostExecute(s);
   Intent intent = new Intent(CurrentActivity.this, Answer.class);
   intent.putExtra("MY_DATA", s);
   startActivity(intent);
}