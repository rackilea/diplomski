@Entity
@Table(name = "Person")
public class Person extends BaseTable  implements Serializable{

@Id
@GeneratedValue
@Column(name = "id")
public getId()
{
   return super.id;
}

setId(log id)
{
   super.id = id;
}

@Column(name = "lastmodifieddate")
@Temporal(TemporalType.DATE) 
public getLastModifiedDate()
{
   return super.lastModifiedDate;
}

setLastModifiedDate(Date date)
{
   super.lastModifiedDate = date;
}

public getName()
// ...
}