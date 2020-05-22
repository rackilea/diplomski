public class Bike {

    private String model;
    private String type;
    private int year;


    private boolean isValidModel(String model) {
        // Making a pattern that checks for the requirements
        Pattern pattern = Pattern.compile("[ A-Za-z0-9]*");
        return pattern.matcher(model).matches();
    }

    private String fixModel(String model) {
        // Replacing all the bad characters
        return model.replaceAll("[^ A-Za-z0-9]", "");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        // Check if the Model is valid
        if (this.isValidModel(model))
            this.model = model; // If so store the model
        else
            this.model = this.fixModel(model); // Store the fixed model
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        // Check if the type contains one of the hard coded types
        if (type.equals("mountain") || type.equals("fixie") || type.equals("cross-country"))
            this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) // Check if the year is positive
            this.year = year;
    }

    public void display() {
        // Displaying the stored information
        System.out.println("Year:" + year + " Model:" + model + " Type:" + type);
    }
}