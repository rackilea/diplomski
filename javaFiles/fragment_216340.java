public class Slave
{
   @Id
   @Column(name = "id")
   long id;

   @Column(name = "master", insertable=false, updatable=false)
   long masterId;
   @JoinColumn(name = "master", referencedColumnName = "id")
   Master master;
}