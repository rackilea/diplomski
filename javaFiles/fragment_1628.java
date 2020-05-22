class College implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private transient City city; //transient
    private String zipCode;

    College(String name, City city, String zipCode) {
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
    }

    private void readObject(ObjectInputStream os) {
        try {
            os.defaultReadObject();
            int code = os.readInt();
            int population = os.readInt();
            String name = (String) os.readObject();
            this.city = new City(code, name, population);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            os.writeInt(1);
            os.writeInt(200);
            os.writeObject("thename");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

class City {
    // the primitive & String fields
    private int code;
    private String name;
    private int population;

    City(int code, String name, int population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // getter/setters
}

public class Launcher {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        City city = new City(375, "New York", 380897);
        College college = new College("NYU", city, "10289");
        College readCollege = null;
        City readCity = null;

        System.out.println("Before serialization -- City: [" + city.toString() + "], College: [" + college.toString() + "]");

        try {
            FileOutputStream fs = new FileOutputStream("college.foo");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(college);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("college.foo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            readCollege = (College) ois.readObject();
            readCity = readCollege.getCity();

            ois.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After serialization -- City: [" + readCity.toString() + "], College: [" + readCollege.toString() + "]");
    }

}