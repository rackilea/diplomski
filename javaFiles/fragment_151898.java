JSONArray courses = new JSONArray();
for(int c = 0; i < 40; c++) {
    JSONObject course = new JSONObject();
    // Add course details
    JSONArray students = new JSONArray();
    for(int s = 0; s < 50; s++) {
        JSONObject student = new JSONObject();
        // Add Student details
        JSONArray assignments = new JSONArray();
        for(int a = 0; a < 100; a++) {
            JSONObject assignment = new JSONObject();
            // Add assignment details
            assignments.put( assignment );
        }
        student.put( "assignments", assignments );
        students.put( student )
    }
    course.put( "students", students );
    courses.put( course );
}