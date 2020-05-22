private void getCompanyByUser() {
//....
@Override
public void onResponse(String response) {
 // ...
//Once the list is made start new activity
if(list.size() > 0) {
    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
    startActivity(intent);
    finish();
} else {
    Intent intent = new Intent(SplashScreenActivity.this, SelectCompany.class);
    startActivity(intent);
    finish();
}
}
}