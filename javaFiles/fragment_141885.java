public Cursor fetchMyValues(String inputText) {

        String DATABASE_TABLE="students";
        return sdb.query(DATABASE_TABLE, new String[] {"_id", "s_name",
                "s_attendance", "s_homework", "s_participation", "s_quiz",
                "s_test", "s_comment", "p_email"}, 
                  "s_name like '%" + inputText +"%'"  , null, null, null, null);}