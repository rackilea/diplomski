public class B{
      @Id 
      @GeneratedValue
      private Integer id;

      private String uuidOfA;



  @ManyToOne
  @JoinColumnsOrFormulas({
  @JoinColumnOrFormula(formula=@JoinFormula(value="(SELECT a.id FROM A a WHERE a.uuid = uuid)", referencedColumnName="id")),
  @JoinColumnOrFormula(column = @JoinColumn("uuidOfA", referencedColumnName="uuid"))
})

     private A a;      
}