@Override
public boolean onMenuItemClick(MenuItem item) {
    Intent intent = new Intent(this, Make_a_contact.class);
    startActivity(intent);
    return true;
}