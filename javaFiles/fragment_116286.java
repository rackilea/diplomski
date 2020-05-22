@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == YOUR_CODE && resultCode == RESULT_OK) {
        Toast.makeText(MainActivity.this, "worked", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "worked", Toast.LENGTH_SHORT).show();
    }
    newGame.setText("PLS ");  //these aren't being called either
    toast("PLS");
}