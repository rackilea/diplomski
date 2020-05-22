@RequestMapping(value="/download/{imageUrl:.+}")
public void getImageByUrl(@PathVariable String imageUrl, 
HttpServletResponse response) throws IOException 
{
    /*
     * Getting The Content From The Images Folder in The Storage Directory
     * Creating an Input Stream and Passing it to The View
     */
    String filesFolder = /* Here goes you storage Folder */;
    File someImage= new File(filesFolder+"/"+imageUrl);
    FileInputStream fileStream=new FileInputStream(someImage);       

            try {
                response.getOutputStream().write(IOUtils.toByteArray(fileStream));
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

}