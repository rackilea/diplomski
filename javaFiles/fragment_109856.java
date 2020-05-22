@Entity
@Table(name="tableA")
Class A{

   @ManyToOne
   @JoinColumn(name = "B_ID")
   B b;

   // some other properties

}

@Entity
@Table(name="tableB")
Class B{

   @OneToMany(mappedBy = "b")
   List Set<A> listOfA= new ArrayList<A>();  

  // some other properties
}