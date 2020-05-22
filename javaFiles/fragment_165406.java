class Employee{

    private int id;
    private String name;
    private List<Address> addresses;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public List<Address> getAddresses()
    {
      return addresses;
    }

    public List<Address> setAddresses(List<Address> addresses)
    {
      this.addresses=addresses;
    }
}