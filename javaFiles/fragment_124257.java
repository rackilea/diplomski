@Column(name = "DATE_COLUMN")
@Temporal(TemporalType.TIMESTAMP)
private Date dateValue;

public Date getDate()
{
   return dateValue;
}