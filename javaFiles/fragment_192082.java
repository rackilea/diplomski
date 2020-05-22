public class Courses {
    public String[] courselist;

    public Courses() throws IOException {  // <-- Added constructor
        loadCourses();                     // <-- Added call to loadCourses
    }

    public void loadCourses() throws IOException {
        int count = 0;
        int counter = 0;
        File f = new File("src//courses//courses.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        List<String> courses = new ArrayList<String>(); // <-- A List can grow 
        while(true){
            String s = reader.readLine();
            if (s.equalsIgnoreCase("*stop*")){
                break;
            }
            courses.add(s);
        }
        courseList = courses.toArray(new String[0]); // <-- assign it here
    }
}