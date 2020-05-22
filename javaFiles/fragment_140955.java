public class CountryDTO {

    private final String value1;
    private final String value2;
    private final String value3;

    public CountryDTO(String a , String b , String c) {
        this.value1 = ((a != null) ? a : "");
        this.value2 = ((b != null) ? b : "");
        this.value3 = ((c != null) ? c : "");
    }

    // just getters; no setters 

}