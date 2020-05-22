public class Person{

@Id
private id;

private String name;

private int media_Id // Add a mediaId field to refer to it in the formula

@Transient
@Formula("SELECT * FROM MEDIA WHERE MEDIA_ID = media_Id")
private List<Media> media= new ArrayList<>();