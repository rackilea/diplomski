public class UserNum {

  @Id
  private ObjectId id;

  @Getter
  @Setter
  public long seq;

  public UserNum(long seq) {
    this.seq = seq;
  }

}