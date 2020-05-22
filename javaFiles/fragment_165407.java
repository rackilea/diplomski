public class Test {
    public static void main(String args[]) {
        ObjectMapper mapper = new ObjectMapper();

        Employee e1= new Employee(1,"John");
        Employee e2= new Employee(2,"Robert");

        Address a1 = new Address ("StreetABC Line 1","StreetABC Line 2", "CityABC","ZipABC");
        Address a2 = new Address ("StreetXYZ Line 1","StreetXYZ Line 2", "CityXYZ","ZipXYZ");
        Address a3 = new Address ("StreetLMN Line 1","StreetLMN Line 2", "CityLMN","ZipLMN");
        Address a4 = new Address ("StreetJQK Line 1","StreetJQK Line 2", "CityJQK","ZipJQK");

        List<Address> address1=new ArrayList<Address>();
        List<Address> address2=new ArrayList<Address>();
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(e1);
        employees.add(e2);


        address1.add(a1);
        address1.add(a2);

        address2.add(a3);
        address2.add(a4);


        e1.setAddresses(address1);
        e2.setAddresses(address2);

        try {
            mapper.writeValueAsString(e1);
            mapper.writeValueAsString(e2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}