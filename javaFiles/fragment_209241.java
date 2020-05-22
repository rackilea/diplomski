@Override
public void onBackPressed() {
    Intent intent = new Intent(this, ActivityA.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    startActivity(intent);
}