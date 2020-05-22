interface Country{
}
interface Address {
    String getStreetAddress();
    String getZipCode();
    Country getCountry();
}
interface Person {
    String getName();
    Address getAddress();
    int getAge();
}
//--- 
Person p;
Country c = p.<CTRL-SHIFT-SPACE>