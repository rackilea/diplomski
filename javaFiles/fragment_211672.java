@Entity
@RevisionEntity()
public class RevisionsInfo extends DefaultRevisionEntity {

  private Long userId;

  public Long getUserId() { return userId; }

  public void setUserId(final Long uid) { this.userId = uid; }

}