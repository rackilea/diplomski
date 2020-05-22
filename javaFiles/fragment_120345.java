@Override
public boolean onOptionsItemSelected(MenuItem item) {
    Intent intent = null;
    switch (item.getItemId()) {
        case R.id.home:
                   intent = new Intent(this, HomeActivity.class);
                   break;
        case R.id.Teams:
                   intent = new Intent(this, TeamsActivity.class);
                   break;
        default:
            return super.onOptionsItemSelected(item);
    }
    startActivity(intent);
    return true;
}