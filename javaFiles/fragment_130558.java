public boolean onNavigationItemSelected(MenuItem menuItem) {

             switch(menuItem.getItemId()){
                 case R.id.nav_home2:
                 startActivity(new Intent(Menu2.this, QuizActivity.class));
                 break;
                 case R.id.nav_about2:
                 startActivity(new Intent(Menu2.this, Menu3.class));
                 break;
             }

                return true;
     }