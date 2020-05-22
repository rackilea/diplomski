@Entity
@Table(name = "book")
class book{
 private int id;
 private String isdn;
 private Info info;

@Id
@Column(name="id_book", unique=true, nullable=false)
@GeneratedValue
 public int getId(){
    return this.id;
 }

 @Column(name="isdn")
 public String getIsdn(){
    return this.idsn;
 }

 public void setId(int id){
    this.id = id;
 }

 public void setIsdn(String isdn){
    this.isdn = isdn;
 }
 @OneToOne
 @PrimaryKeyJoinColumn
 public Info getInfo(){
    return this.info;
 }

 public void setInfo(Info info){
    this.info = info;
 }
}

@Entity
@Table(name = "info")
class Info{
 private int id;
 private String title;
 private String author;
 private Book book;

    @Id
    @Column(name="id_info", unique=true, nullable=false)
    @GeneratedValue
 public int getId(){
    return this.id;
 }

 @Column(name="title")
 public String getTitle(){
    return this.title;
 }

 public void setId(int id){
    this.id = id;
 }

 public void setTitle(String title){
    this.title = title;
 }
 @OneToOne(mappedBy="info", cascade=CascadeType.ALL)
 public Book getBook(){
    return this.book;
 }

 public void setBook(Book book){
    this.book = book;
 }
 public void setAuthor(String author){
    this.author = author;
 }
  @Column(name="author")
 public String getAuthor(){
    return this.author ;
 }


}