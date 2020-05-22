class Person {
    private String name;
    private String homeCity;
    private int customerNumber;

    public Person(String name, String homeCity, int customerNumber) {
      this.name = name;
      this.homeCity = homeCity;
      this.customerNumber = customerNumber;
    }

    public boolean isMatch(int num) {
      return num == customerNumber;
    }

    @Override
    public String toString() {
      return name + " from " + homeCity; 
    }
}