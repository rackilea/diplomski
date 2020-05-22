@Entity
public class SampleData {
    // other columns 

    @Column(name="SAMPLE", columnDefinition="CLOB NOT NULL") 
    @Lob 
    private String sample;

    // setters and getters
}