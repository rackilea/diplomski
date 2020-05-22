@Entity
@Component("BusDetails")
public class BusDetails {

    //...

    @Column
    private Date date;

    //setter(can add or modify) should be custom like below :
    public void setDate(String date){
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // ...getter & setter
}