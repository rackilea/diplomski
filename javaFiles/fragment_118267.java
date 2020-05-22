public class MyBlobWrapper {
    @Id
    public Long getId() {
       return id;
    }
    @Lob
    public String getBlob() {
        return blob;
    }
    @OneToOne(fetch=FetchType.LAZY,optional=false) 
    public MyClass getParent() {
        return parent;
    }
}