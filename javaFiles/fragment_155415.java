public class UploadAction extends ActionSupport{

    private File   upload;
    private String uploadFileName;
    private String uploadContentType;

    public void setUpload(File upload){
        this.upload=upload;
    }
    public void setUploadContentType(String uploadContentType){
        this.uploadContentType=uploadContentType;
    }
    public void setUploadFileName(String uploadFileName){
        this.uploadFileName=uploadFileName;
    }

    @Override
    public String execute(){
        if(upload==null)
        {
            System.out.println("No file....");
        }
        System.out.println(uploadContentType);
        System.out.println(uploadFileName);
        return SUCCESS;
    }
}