public class CourseQuerySystem {
    public static void main(String[] args) throws FileNotFoundException{
        FileReader reader = new FileReader("CoursesOffered.json");
        JSONArray courseData = (JSONArray)JSONValue.parse(reader);
        JSONObject firstCourse = (JSONObject)courseData.get(0);  // first course
        System.out.println(firstCourse); // it works 

        String courseNo = (String) firstCourse.get.get("Course").get("CourseNo");
        System.out.println(courseNo); // Should work
    }
}