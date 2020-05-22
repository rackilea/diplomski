public class CreateAction extends ActionSupport {

   private File productImage;
   private String myFileContentType;
   private String myFileFileName;
   private String destPath;

   @Action("/createProduct")
   public String execute() {

  destPath = "destination file folder";

  try{

     File destFile  = new File(destPath, myFileFileName);
     FileUtils.copyFile(productImage, destFile);

     }catch(IOException e){
     e.printStackTrace();
      }
    return "success";
   } 
   public File getProductImage() {
      return productImage;
    }
     public void setProductImage(File productImage) {
       this.productImage= productImage;
       }
      public String getMyFileContentType() {
      return myFileContentType;
     }
   public void setMyFileContentType(String myFileContentType) {
      this.myFileContentType = myFileContentType;
     }
    public String getMyFileFileName() {
       return myFileFileName;
      }
    public void setMyFileFileName(String myFileFileName) {
       this.myFileFileName = myFileFileName;
      }

   }