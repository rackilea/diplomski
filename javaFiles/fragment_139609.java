public class Student {

    private String firstName;
    private String middleName;
    private String lastName;
    private String assignmentNumber;

    /**
     * The Student Class constructor that can optionally accept arguments. 
     * If a single argument is supplied and it consists of a comma (,) 
     * delimited CSV file line as a single string, that string will be 
     * split and the elements placed into the appropriate class fields.
     * If multiple arguments are supplied then it is assumed that those
     * string arguments represent the contents for our class field 
     * components which are assignmentNumber, lastName, middleName, and 
     * firstName (in that order). Of course if nothing is supplied this
     * is just an empty constructor.<br><br>
     * 
     * @param inputString (Optional - String) Read the above.
     */
    public Student (String... inputString) {
        String inString;
        if (inputString.length > 0) {
            // Single file line assumed...
            if (inputString.length == 1) {
                inString = inputString[0]; 
                if (!inString.equals("")) {
                    if (!inString.contains(",")) { 
                        throw new IllegalArgumentException("Student value can not be empty "
                                    + "OR Student value must be a comma delimited String!");
                    }
                    String[] values = inString.split(",|,\\s+");
                    if (values.length >= 1) { this.assignmentNumber = values[0]; }
                    else { this.assignmentNumber = ""; }
                    if (values.length >= 2) { this.lastName = values[1]; }
                    else { this.assignmentNumber = ""; }
                    if (values.length >= 3) { this.middleName = values[2]; }
                    else { this.middleName = ""; }
                    if (values.length >= 4) { this.firstName = values[3]; }
                    else { this.firstName = ""; }
                }
            }
            else {
                if (inputString.length >= 1) { this.assignmentNumber = inputString[0]; }
                if (inputString.length >= 2) { this.lastName = inputString[1]; }
                if (inputString.length >= 3) { this.middleName = inputString[2]; }
                if (inputString.length >= 4) { this.firstName = inputString[3]; }
            }
        }
    }

    /**
     * Overriden - Student.toString() method with no arguments to return a 
     * string like:  "17-995-364 Ruh Konrad Julia"
     * based from what is contained within the class fields.<br><br>
     * 
     * @return (String)
     */
    @Override
    public String toString() {
        String s = assignmentNumber + " " + lastName + " " + middleName + " " + firstName;
        return s;
    }


    /**
     * A static Student.toString() method that takes a string argument 
     * which is to be considered a single line of CSV file text. This
     * method will return a String Array containing elements which 
     * could look like this: [17-995-364, Ruh, Konrad, Julia]<br><br>
     * 
     * @param inputString (String) A single line of comma delimited CSV 
     * file text.<br>
     * 
     * @return (Single Dimensional String Array) 1D String Array containing 
     * specific elements from the supplied comma delimited CSV file line.
     */
    public static String[] toString(String inputString) {
        String[] s = inputString.split(",|,\\s+");
        return s;
    }

    /**
     * A Overloaded static Student.toString() method that takes a String Array
     * argument which is to be considered a single line of CSV file 
     * text that is split to create that array. This method will 
     * return a String containing which could look like this:<br><br> 
     * "17-995-364 Ruh Konrad Julia"<br><br>
     * 
     * @param inputArray (Single Dimensional String Array)<br>
     * 
     * @return (String) See Above...
     */
    public static String toString(String[] inputArray) {
        String s = "";
        for (String inputArray1 : inputArray) {
            s += s.equals("") ? inputArray1 : " " + inputArray1;
        }
        return s;
    }

    // Field Getters And Setters to enhance the class
    // for better usability.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(String assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }

}