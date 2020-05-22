@Override
public void onClick(View v) {
    // TODO Auto-generated method stub

    switch(v.getId()){
    case R.id.imageButton1:
        Constants.water = 1;
        Intent wi = new Intent("com.example.themetest.THEME");
        startActivity(wi);
        break;

    case R.id.imageButton2:
        Constants.fire = 1;
        Intent fi = new Intent("com.example.themetest.THEME");
        startActivity(fi);
        break;
    }
}