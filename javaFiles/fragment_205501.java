public class SelectOneMenuBean {
    private String selectedValue;

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String[] getCities() {
        if(selectedValue != null && selectedValue.equals("AAA")) {
            return new String[] {"City_1 of AAA", "City_2 of AAA", "City_3 of AAA"};
        } else if(selectedValue != null && selectedValue.equals("BBB")) {
            return new String[] {"City_1 of BBB", "City_2 of BBB", "City_3 of BBB"};
        } else if(selectedValue != null && selectedValue.equals("CCC")) {
            return new String[] {"City_1 of CCC", "City_2 of CCC", "City_3 of CCC"};
        } else if(selectedValue != null && selectedValue.equals("DDD")) {
            return new String[] {"City_1 of DDD", "City_2 of DDD", "City_3 of DDD"};
        } 
        return new String[] {"No City"};
    }
}