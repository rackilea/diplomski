heal.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor=pref.edit();
          editor.putString("chestdmg1", "");
          editor.putString("chestdmg2", "");
          editor.putString("chestdmg3", "");
          editor.putString("chestdmg4", "");
          editor.putString("chestdmg5", "");
          editor.putString("chestdmg6", "");
          editor.putString("chestdmg7", "");
          editor.putString("chestdmg8", "");
          editor.putString("chestdmg9", "");
          editor.putString("chestdmg10", "");
          editor.commit();                

        }
    });