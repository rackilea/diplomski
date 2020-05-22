public class TestObject {

//Some fields.
private int firstInt;
private int secondInt;
private String firstString;

public TestObject(int firstInt, int secondInt, String firstString) { 
    this.firstInt = firstInt;
    this.secondInt = secondInt;
    this.firstString = firstString;
}

public void checkForNulls(String... fieldsToSearch) throws IllegalArgumentException, IllegalAccessException {

    boolean isValid = true;

    //Here we retrieve all the fields we need from our class.
    for (String fieldName : fieldsToSearch) {
        //Here is the method to get a field by name.
        try {
            Field field = this.getClass().getDeclaredField(fieldName);

            //Change access modifier so we can get the value.
            field.setAccessible(true);

            //Get the field value of this instance.
            if (field.get(this) == null) {
                isValid = false;
                System.out.println("Fix him! Field " + field.getName() + " equals null!");
            }

        } catch (Exception e) {
            //There can be no field with such name, you need to do something here.
        }
    }

    if (isValid) {
        System.out.println("This objects fields are fine.");
    }
}
}