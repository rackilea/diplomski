public class MyClass {

    public boolean isMp3(File file) {
        Pattern pattern;
        final String FILE_PATTERN = "([^\\s]+(\\.(?i)(mp3))$)";
        pattern = Pattern.compile(FILE_PATTERN);
        Matcher matcher = pattern.matcher(file.toString());
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public void myMethod() {
        File file = new File("file1.mp3");
        if (isMp3(file)) {
            System.out.println("is an  MP3");
        } else {
            System.out.println("not an MP3");
        }
    }

}