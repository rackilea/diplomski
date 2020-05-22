@Entity
@EntityListeners(FilerService.class)
public class MyDocument {
    @Id
    private Long documentId;
    private String fileName;
    private String filePath;
    //Then a lot of other fields, getters and setters
}