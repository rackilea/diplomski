public class Data {

    @JsonFormat(pattern = "MM/dd/yyyy", timezone="GMT-04:00")
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

public class Main {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue("{\"date\" : \"04/02/2017\"}", Data.class);
        System.out.println(data.date);
    }
}