Map<String,SCHOOL> schools = directory.getSchools();
for( SCHOOL school: schools.values() ){
    for( STUDENT student: school.getStudents() ){
        Log.d( ... student.getName() + " " + student.getAge() ... );
    }
}