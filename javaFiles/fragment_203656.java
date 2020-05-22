public class UserManager {

private final DBI dbi;

public UserManager (final DBI dbi) {
    this.dbi = dbi;
    // there are other daos and clients passed here
}

public void foo() {
    dbi.useTransaction((handle, transactionStatus) -> {
        UserDao dao = handle.attach(UserDao.class);
        dao.action1();
        dao.action2();
    });
  }
}