@Document(collection="brands")
public class Brand{
    @Id
    private Integer id;

    private String name;
    ...
    //getters-setters
}

@Document(collection="models")
public class Model{
    @Id
    private Integer id;
    private String name;
    @DBRef
    private Brand brand;
    ...
    //getters-setters
}