/*
* Class Responsibility: read the file content and return it as a something usable
*/ 
class MyFileReader {
    public List<String> read(String filename) {
        /*
         * 1. open a file for reading
         * 2. read each line and add it to a list
         * 3. return the list (represents our file content)
         */
    }
}

/*
* Class Responsibility: take the content which we read from a file and turn it 
*   into usable Java objects 
*/
class MyFileProcessor {
    public List<Info> process(List<String> linesFromFile) {
        /*
         * 1. for each string (that represents a line from the input file)
         * 2. split it into identifiable parts
         * 3. create a new object to hold each of these parts  
         * 4. add that object to a list
         * 5. return the list
         */
    }
}

/*
 * Class Responsibility: write the java objects to a file 
 *  Note*: this is much easier if you override the toString method for your 
 *          info object
 */
class MyFileWriter {
    public void writeToFile(List<Info> infoObjects, String filename) {
        /*
         * 1. open a file using the filename for writing
         * 2. write some content
         * 3. close file
         */
    }
}

/*
 * Class Responsibility: hold the values that we care about
 */
class Info {
    private String name;
    private int id;
    private String email;
    private String password;

    public Info(String name, int id, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    /*
     * ... getters and setters
     */
}