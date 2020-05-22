if(savedLogged) {

    Intent intent = new Intent(this, ActivityOverview.class);
    startActivity(intent);
    finish();
}
setContentView(R.layout.activity_login);