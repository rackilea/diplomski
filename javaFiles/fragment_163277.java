public class ClassTest {
    // Specify a base path for all paths to be used
    public static final String BASE_PATH = "C:/Users";
    // 1. If these paths will be used in several methods, declare them here
    public static final String dirPath = BASE_PATH + "/test1/"; 
    public static final String pathOut = BASE_PATH + "/stats.csv"; 

    public static void main(String[] args) {
        // 2. If those paths will be used in the main method only, declare them here
        final String dirPath = BASE_PATH + "/test1/"; 
        final String pathOut = BASE_PATH + "/stats.csv"; 
    }   
}