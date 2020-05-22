@CsvRecord(separator=",")
public class Student {  
    @DataField(pos=1)
    private String name;

    @DataField(pos=2)
    private String college;

    @Link
    private Address address;
...
}