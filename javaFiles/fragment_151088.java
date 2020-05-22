public class SubCompany {
    //Just so you can ignore in Json 
    @JsonIgnore
    String type;

    int id;

    // All fields from Company Class
    String companyName;
    String projectName;
    int duration;

    //Remaining fields from Subject Class
    String institutionName;
    String subject;

    //Getters and Setters

    public SubCompany() {
        //At the end call method to test the type
        setType();
    }

    private void setType() {
        if (null != institutionName && null != subject)
            type = "Subject";
        else
            type = "Company";
    }

    //At this point the type is set so you know what you have Company or Subject
    //Now write customized writers.

    public Company getComany() {
        Company company = new Company();
        //Set all the fields accordingly.
        return company;
    }

    public Subject getSubject() {
        //In the similar fashion, write this method to get Subject.
    }

}