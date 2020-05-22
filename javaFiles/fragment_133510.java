iconD.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             if (view.getId() == R.id.picture_d) {
                 if (iconR.isPressed() && iconD.isPressed()) {
                       askingForClosingTheApp();
                 }
              }
              return true;
         }
   });