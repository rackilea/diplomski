public class ReadingFiles {

    BufferedReader br;
    ArrayList<File> list = new ArrayList<>();

    ReadingFiles() {
        list.add(new File((getClass().getResource("file1.txt")).getPath()));
        readFile(list.get(0));
        list.add(new File((getClass().getResource("file2.txt")).getPath()));
        readFile(list.get(1));
    }

    public void readFile(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("Sorry");
        }
    }
    public static void main(String[] args){
        new ReadingFiles();
    }
}