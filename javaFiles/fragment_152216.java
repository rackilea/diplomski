import com.fasterxml.jackson.annotation.JsonFormat;


public class Reponse {

    private String event;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date eventDate;

    private Double amount;
}