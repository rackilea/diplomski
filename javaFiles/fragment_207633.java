@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Record")
public class Record
{
    @XmlAttribute(name="status")
    private Status status  ;

    @XmlAttribute(name="error")
    private String getError(){
        return status.getError();
    }
}

public enum Status 
{
    OK(0, "No error"),
    ERROR(1, "Some error") ;

    private Integer status ;
    private String error ;

    private Status(Integer status, String error)
    {
        this.status=status ;
        this.error=error ;
    }

    public String getError(){
        return this.error;
    }
}