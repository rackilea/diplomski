mStartGame.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
         NewGameCourseItem  item = adapter.getSelecteditem();
         Intent intent = new Intent(ActivityNewGame2.this, ActivityGame.class);
         /** Also intent selected items: course name and hole number **/
         intent.putExtra("COURSENAME", item.getCourseName());
         intent.putExtra("HOLESNM", item.getHolesNm());
         startActivity(intent);
         overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
      }
 });