public class EntityA{

   @EmbeddedId  
   private SirenNdaKey sirenNda;

   @OneToMany(fetch = FetchType.LAZY)
      @JoinColumns({ @JoinColumn(name = "B_SIREN", 
    referencedColumnName = "A_SIREN"),
      @JoinColumn(name = "B_NDA", referencedColumnName = "A_NDA") 
    })
   private Set<EntityB> EntityBSet;
   ...
}