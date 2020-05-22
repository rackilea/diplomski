@Entity
@Table(name = "MY_TABLE")
public class MyTable implements Serializable {
  . . .
  @Column(name = "START_DATE")
  @Type(type="org.jadira.usertype.dateandtime.legacyjdk.PersistentDate")
  private Date startDate;
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  . . .
}