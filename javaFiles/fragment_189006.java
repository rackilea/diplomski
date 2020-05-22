public class VacancyModel implements Serializable{
    private String profession;
    private String header;
    private String salary;
    private String date;
   // set setter and getter for both, by default isHeading will be false,
    private boolean isHeading;
    private String heading;


    public VacancyModel() {
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSalary() {
        if (salary.equals("0") || salary.isEmpty() || salary.equals("null")){
            return "empty";
        }
        else {
            return salary;
        }
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}