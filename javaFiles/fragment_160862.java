@Override
public boolean onNavigateUp() {
    Intent intentMain = new Intent(ChildAct.this, MainActivity.class);
    startActivity(intentMain );
    return false;
}