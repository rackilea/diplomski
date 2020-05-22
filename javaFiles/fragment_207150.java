//insert Subjects
public boolean insertSubjects(Integer id, Integer uid, String sname, String sresults, String shours) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues cv = new ContentValues();

    cv.put(user.USER_ID, id);
    cv.put(subject.SUBUSER_ID, uid);
    cv.put(subject.SUBJECT_NAME, sname);
    cv.put(subject.SUBJECT_RESULTS, sresults);
    cv.put(subject.SUBJECT_HOURS, shours);
    long sub_id =  db.insert(subject.TABLE_SUBJECT, null, cv);

    if (sub_id == -1){
        return false;
    }else
        return true;
    }
}