public class Student implements Serializable {
    String first;
    String second;
    String phone;
    String cityAddress;
    String cityStreet;

    public Student(String s1, String s2, String s3, String s4, String s5) {
        first = s1;
        second = s2;
        phone = s3;
        cityAddress = s4;
        cityStreet = s5;
    }
}