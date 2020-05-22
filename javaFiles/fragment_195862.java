@Override
    public void onBackPressed() {
        Intent i = new Intent(MainActivity.this, StartedActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | 
        Intent.FLAG_ACTIVITY_NEW_TASK);
        MainActivity.this.startActivity(i);
        super.onBackPressed();
    }