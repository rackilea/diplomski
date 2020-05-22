public static void main(String[] args) {
    CMS cms = new CMS();
    // * This is Van object.
    cms.addVehicle(new Van("v1", "Toyota", "Sienna", 1998, 0.0, 500.0));
    cms.addVehicle(new Van("v2", "Volkswagen", "Routan S", 2009, 0.0, 1000.0));
    for (String s : cms.getVehicles())
        System.out.println(s);
}

public class CMS {

    private ArrayList<String> vehicles = new ArrayList<String>();

    public ArrayList<String> getVehicles() {
        return this.vehicles;
    }

    public void addVehicle(String van) {
        vehicles.add(van);
    }

}