@Entity
public class MainEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "main_Id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SubEntity  subEntity ;
}


@Entity
public class SubEntity 
{
    @Id @Column(name="main_Id_FK") Long id;

    @MapsId 
    @OneToOne
    @JoinColumn(name = "main_Id_FK")    
    @PrimaryKeyJoinColumn
    private MainEntity mainEntity;        

}