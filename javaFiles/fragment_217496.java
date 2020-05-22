@MappedSuperclass
 public class Base {
   private String message;
   private String autor;
   @Column(name = "MESSAGE")
   public String getMessage(){
     return message;
   }
   public void setMessage(final String message) {
     this.message = message;
   }
   @Column(name = "AUTOR")
   public String getAutor(){
     return autor;
   }
   public void setAutor(final String autor) {
     this.autor = autor;
   }
 }