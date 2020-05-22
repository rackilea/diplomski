// code in your application builder
// assuming an interface called UserDAO
UserDAO userDAO = new STKUserDAO();
CommitmentItemForm form = new CommitmentItemForm(userDao);


public class CommitmentItemForm {

  private final UserDAO userDao;
  public CommitmentItemForm(UserDAO userDao) { this.userDao = userDao; }

  public Object edit(HttpServletRequest request) {
    ...
    deptSupervisorList = userDao.getList(authenticatedUser.getDepartment());
    ...
  }

}