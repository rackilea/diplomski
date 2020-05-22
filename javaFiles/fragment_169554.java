public boolean onOptionsItemSelected(MenuItem item) {


          SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
          final SharedPreferences.Editor editor = myPrefs.edit();
          favClicked = myPrefs.getBoolean("menu_item", false);


          switch (item.getItemId()) {
           case R.id.id_favorit:
                favClicked=true;
                editor.putBoolean("menu_item", favClicked);
                editor.commit();
                invalidateOptionsMenu();
                return true;

            case R.id.id_favorit2:

                favClicked=false;
                editor.putBoolean("menu_item", favClicked);
                editor.commit();
                invalidateOptionsMenu();
                return super.onOptionsItemSelected(item); 
            }
        return true;
        }
           @Override
            public boolean onPrepareOptionsMenu(Menu menu) {


         if(favClicked==true){
               menu.findItem(R.id.id_favorit).setVisible(false);
                menu.findItem(R.id.id_favorit2).setVisible(true);

         }else{
           menu.findItem(R.id.id_favorit).setVisible(true);
            menu.findItem(R.id.id_favorit2).setVisible(false);

     }



                return super.onPrepareOptionsMenu(menu);
            }


   }