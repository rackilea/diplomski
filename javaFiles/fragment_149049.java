viewHolder.toggleBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (viewHolder.toggleBtn.isChecked()) {
                String test1 = item.getStudentID();
                Student favStudent = realm.where(Student.class).equalTo("StudentID", test1).findFirst();
                realm.beginTransaction();
                favStudent.setStudentFavourite(true);
                realm.commitTransaction();
                viewHolder.toggleBtn.setChecked(true);
                //Log.d("toggle", test1);

            } else {
                String test2 = item.getStudentID();
                Student notfavStudent = realm.where(Student.class).equalTo("StudentID", test2).findFirst();
                realm.beginTransaction();
                notfavStudent.setStudentFavourite(false);
                realm.commitTransaction();
                viewHolder.toggleBtn.setChecked(false);
                //Log.d("toggle", test2);


            }
        }