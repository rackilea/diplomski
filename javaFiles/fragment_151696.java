class Data {
    List<String> userNames = new ArrayList<>();

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames( List<String> userNames ) {
        this.userNames = userNames;
    }
}

public static void main( String[] args ) throws IOException
{
    String obj = " {\"userNames\":[\"aaaaa aaaaa\",\"Anders Ohm\",\"Arthur Hansen\"]}";

    ObjectMapper mapper = new ObjectMapper();
    Data data = mapper.readValue( obj, Data.class );

    System.out.println(data.getUserNames());
}