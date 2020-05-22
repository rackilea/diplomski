@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch (item.getItemId()){
                case R.id.home:
                    textView.setText("Home");
                    return true;
                case R.id.notification:
                    textView.setText("Notification");
                    return true;
                case R.id.profile:
                    textView.setText("Profile");
                    return true;
                    default:
                        return super.onOptionsItemSelected(item);
            }
      }