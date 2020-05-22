List<Grade>grades = new ArrayList<>();
ARRAY gradesList = (ARRAY)rs.getObject("GRADES");
if(gradesList != null && gradesList.length() != 0) {
    Datum[] elems = gradesList.getOracleArray();    

    for(int i = 0; i<elems.length;i++) {
        STRUCT gradeInfo = (STRUCT) elems[i];
        Object[] gradeInfoValues = gradeInfo.getAttributes();
        Grade grade = new Grade();
        /*SETTING GRADE OBJECT ATTRIBUTES BY USING gradeInfoValues ARRAY ...*/
        grades.add(grade);
        }
    }