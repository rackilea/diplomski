@Entity
public class Campaign {
  // ...
  @OneToMany
  private List<MailingList> lists;
}

@Entity
public class MailingList {
  // ...
  @ManyToMany
  private List<Subscriber> subscribers;
}

@Entity
public class Subscriber {
  // ...
}