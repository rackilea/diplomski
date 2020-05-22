public class Sample {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Class<FileNames> clazz = FileNames.class;
        Field[] arr = clazz.getFields(); // Get all public fields of your class
        for (Field f : arr) {
            if (f.getType().equals(String.class)) { // check if field is a String
                String s = (String)f.get(null); // get value of each field
                // add s to a List
                System.out.println(s);
            }

        }
    }

}

 final class FileNames {

    private FileNames() {
    }

    public static final String A = "a.csv";
    public static final String B = "b.csv";
    public static final String C = "123.csv";

}