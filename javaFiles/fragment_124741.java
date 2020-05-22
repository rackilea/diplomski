public static void main(String[] args) {

    Scanner sc = null;
    try {
        File f = new File("test.txt");
        sc = new Scanner(f);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] details = line.split(" ");
            for(String str: details) {
                //variable str contains each value of the string split
                System.out.println(str);
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        sc.close();
    }
}