public static void main(String[] args) {
    String name = args[1];

    try {
        Person person = PersonHelper.getPerson(name);
    }
    catch(MalformedURLException e) {
        // Handle exception
    } 
    catch(IOException e) {
        // Handle exception
    } 
    catch(JSONParseException e) {
        // Handle exception
    } 
}