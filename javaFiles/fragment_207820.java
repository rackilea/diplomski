final Intent intent = new Intent(this, DisplaySpecificPage.class);
switch (view.getId()) {
    case R.id.first_button:
        intent.putExtra("mylayout", R.layout.one);
        break;
    case R.id.second_button:
        intent.putExtra("mylayout", R.layout.two);
        break;
    case R.id.third_button:
        intent.putExtra("mylayout", R.layout.three);
        break;
    case R.id.random_button:
        intent.putExtra("mylayout", randomNumber);
        startActivity(intent);
}
startActivity(intent);