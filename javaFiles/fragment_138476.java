public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    String [] characteristics = new String[]{};
    Employee emp = new Employee("John", "20", "Male", characteristics);
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    mapper.writeValue(System.out, emp);
}
class Employee {
    String name;
    String age;
    String gender;
    String [] characteristics;
    //setters and getters
    }