class IQIncreaser implements Serializable{
    int Iq ;

    public int getIq() {
        return Iq;
    }

    public void setIq(int iq) {
        Iq = iq;
    }

}


public class Main {

    public static void main(String[] args) {
        Path path = Paths.get("/home/akshayap/saveIQ.ser");
        //create default file only if it does not exist
        if (Files.notExists(path)) {
        IQIncreaser bakra = new IQIncreaser();
        bakra.setIq(80);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/akshayap/saveIQ.ser"));
            oos.writeObject(bakra);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        System.out.println("Welcome to the IQ increaser!!!");
        System.out.println("Whenver you run this game your IQ will increase by 1!!");
        System.out.println("Just check it out");


        IQIncreaser restoredAndIncreased=null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/akshayap/saveIQ.ser"));
            restoredAndIncreased = (IQIncreaser) ois.readObject();
            System.out.println("Your IQ at beginning was " +restoredAndIncreased.getIq() + ", come back for more");
            // Here I am increasing the IQ by one everytime the main runs
            restoredAndIncreased.setIq(restoredAndIncreased.getIq()+1);

            System.out.println("The increased IQ is " + restoredAndIncreased.getIq());
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //serialize the object into the same file post increment
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/akshayap/saveIQ.ser"));
            oos.writeObject(restoredAndIncreased);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }