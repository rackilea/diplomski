public void receiveMagic(Boolean isGood){
    if (isGood){
        Toast.makeText(MainActivity.this, "It is good", Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(MainActivity.this, "It is not connected", Toast.LENGTH_SHORT).show();
    }
}