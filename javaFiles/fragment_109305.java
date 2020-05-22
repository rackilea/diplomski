public class CommitmentItemForm {

  public CommitmentItemForm()

  public Object edit(HttpServletRequest request) {
    ...
    deptSupervisorList = STKUserDAO.getList(authenticatedUser.getDepartment());
    ...
  }

}