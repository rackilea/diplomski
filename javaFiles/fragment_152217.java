public class CC {
public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(new File("file.txt"));

    while (scan.hasNext()) {
        String f1[] = null;
        f1 = scan.nextLine().split("(.*?);");
        for (int i = 0; i < f1.length; i++) {
            System.out.print(f1[i]);
        }
    }
    scan.close();

    BufferedReader br = new BufferedReader(new FileReader(new File("file.txt")));
    String str = null;
    while ((str = br.readLine()) != null) {
        String f1[] = null;
        f1 = str.split("(.*?);");
        for (int i = 0; i < f1.length; i++) {
            System.out.print(f1[i]);
        }
    }
    br.close();
}
}