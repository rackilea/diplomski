class Student {

    private int age;    
    public int getAge() {
        return age;
    }

    public void setAge(String ageString) {
        System.out.println("called");
        try {
            age = Integer.parseInt(ageString);
        } catch (NumberFormatException e) {
           throw new IllegalArgumentException("age can't be in float");
        }
    }
}

...

try {
    Student student = new ObjectMapper().readValue("{\"age\": 12.5}", Student.class);
} catch (IllegalArgumentException e) {
    e.printStackTrace();
}