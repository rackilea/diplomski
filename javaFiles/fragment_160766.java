@RequestMapping(value="getFile", method=RequestMethod.GET)
public void getFile(HttpServletResponse response,HttpServletRequest request) {
     String environmentName = request.getParameter("name");
    //here the code to get your file as stream 
    //whether getting the file by Ressource or buffred ,
    //here for example I named a getfileStream() method wihch return your file  InputStream
    InputStream myStream  = getFileStream(environmentName);


    // Set the content type and attachment header add filename and it's extention.
    response.addHeader("Content-disposition", "attachment;filename=myfile.myExtention");
    response.setContentType("txt/plain");

    // copy your file stream to Response 
    IOUtils.copy(myStream, response.getOutputStream());
    response.flushBuffer();
}