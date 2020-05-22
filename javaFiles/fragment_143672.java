@Entity
public class SchemaN{

    @OneToMany(targetEntity=MainSchema.class, mappedBy="pk_SchemaN")
    private List<MainSchema> ms;

...

}

@Entity
public class MainSchema{

     @ManyToOne
     @JoinColumn(name="FK_MainSchema")
     private SchemaN pk_schemaN;

...

}