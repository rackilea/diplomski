public void gotoActivity(View view) {
 Intent intent = new Intent(this, TargetActivity.class);
 intent.putExtra("btnClicked", "Strings");
 startActivity(intent);

}