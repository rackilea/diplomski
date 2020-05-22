@Entity
public abstract class A implements Serializable {
  @Id
  public Long id;

  public String a1;
  public String a2;
  public String a3;

  //much more fields    
  //getters and setters
}

@Entity
public class B implements Serializable {

  @Id  
  @Column(name="id", nullable=false)  
  public Long id;

  @MapsId  
  @OneToOne(optional=false)  
  @JoinColumn(name="id")  
  public A a;

  public String b1;  
  public String b2;  
  public String b3;

  //much more fields
  //getters and setters
}

@Entity
public class C extends A {  

  public String c;
  //that's it. no more data

  //getters and setters
}