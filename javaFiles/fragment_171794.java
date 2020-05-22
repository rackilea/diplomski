public class Main {

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter(new File("F://test.txt"));
            Scanner sc = new Scanner(System.in);
            int students = 2;
            double[] doubleAVG = new double[students];
            char[] charGRADE = new char[students];
            double avg = 0.0;
            char gradeLetter;
            String FirstName = "";
            String LastName = "";
            for (int count = 0; count < students; count++) {
                System.out.println("Enter average :");
                avg = sc.nextDouble();
                System.out.println("Enter grade :");
                gradeLetter = sc.next().charAt(0);
                System.out.println("Enter First Name :");
                FirstName = sc.next();
                System.out.println("Enter Last Name :");
                LastName = sc.next();
                doubleAVG[count] = avg;
                charGRADE[count] = gradeLetter;
                fw.write("This is the grade of: " + FirstName + " " + LastName + " ");
                fw.write(String.valueOf(doubleAVG[count]) + " ");
                fw.write(charGRADE[count] + System.lineSeparator());
            }
            fw.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}