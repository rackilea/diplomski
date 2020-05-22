public class Comment {
   @Column  
   private String text;             

   @ManyToOne
   private Comment parent;

   @OneToMany(cascade=CascadeType.ALL, mappedBy="parent") // or orphanRemoval=true
   private Set<Comment> childs = new HashSet<Comment>();
}