import java.util.*;

public class PublicationListingProcess1 extends Publication implements Serializable{
    static ArrayList<Publication> pubs;
    static String a, n, line;
    static int y, p, count = 0;
    static long z;
    static double s;

    enum PublicationTypes{
        PUBLICATIONCODE, 
        PUBLICATIONNAME, 
        PUBLICATIONYEAR, 
        PUBLICATIONAUTHORNAME, 
        PUBLICATIONCOST, 
        PUBLICATIONNBPAGES;
    }

    public static void main(String[] args)  {
    // TODO Auto-generated method stub
        try{
               File f = new File("PublicationData_Input.txt");
            Scanner input = new Scanner(f);

               pubs = new ArrayList<>();

            System.out.println("Welcome to this organizing software.");
            System.out.print("Please enter the destiny file for output: ");
            Scanner kb = new Scanner(System.in);

            File outFile = new File(kb.next()+".txt");
            FileWriter output = new FileWriter(outFile);
            PrintWriter writer = new PrintWriter(output);

            while (input.hasNextLine()) {
                String[] split = input.nextLine().split(" ");

                for (int i = 0; i < split.length; i++) {
                    z = Long.parseLong(split[0]);
                    n = split[1];
                    y = Integer.parseInt(split[2]);
                    a = split[3];
                    s = Double.parseDouble(split[4]);
                    p = Integer.parseInt(split[5]);
                    pubs.add(new Publication(z, n, a, y, s, p));
                    writer.println(pubs.get(count);
                    count++;
                }

            }
            output.close();
            input.close();
        } catch(RuntimeException e) {
            e.getMessage();
        } catch (FileNotFoundException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}