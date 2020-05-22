//In FileUploadServletAction
public String execute() throws Exception{
 try {
      String filePath = request.getSession().getServletContext().getRealPath("/");           
      File fileToCreate = new File(filePath, this.userKeyFileName);
      FileUtils.copyFile(this.userKey, fileToCreate);
  } catch (Exception e) {
    e.printStackTrace();
    addActionError(e.getMessage());
    return INPUT;
 }

 return SUCCESS;
}