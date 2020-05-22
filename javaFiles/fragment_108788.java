public class FileNamePrinter {
    public String print(List<File> files) {
        StringJoiner joiner = new StringJoiner("," "[", "]");
        for (File file : files) {
            joiner.add(file.getName());
        }
        return joiner.toString();
    }
}