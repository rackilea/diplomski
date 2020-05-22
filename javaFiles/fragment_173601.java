public class BusinessContact extends Contact {
    String businessPhone;
    String cellPhone;

    public BusinessContact(String name, int age, String businessPhone, String cellPhone){
        super(name, age);
        this.businessPhone = businessPhone;
        this.cellPhone = cellPhone;
    }

    public String toString(){
        return "Name: " + this.name + " Age: " + Integer.toString(age) + " Business Phone: " + businessPhone + " Cell Phone: " + cellphone;
    }
}