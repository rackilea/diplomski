//...
String fileName = generateFileName(request);//Generate the image file name
byte[] imageBytes = getByteArray(request);//Generate the image bytes
//Where to save the image part
ServletContext adminContext = request.getServletContext();//ZaapMartAdmin context
ServletContext uploadsContext = adminContext.getContext("/ImageUploads");//ImageUploads context
String absolutePath = uploadsContext.getRealPath("");
File imagesDirectory = new File(absolutePath + File.separator + "images");
if(!imagesDirectory.exists())
    imagesDirectory.mkdir();
try(FileOutputStream fos = new FileOutputStream(absolutePath + File.separator + "images" + File.separator + fileName);)
{
      fos.write(imageBytes);//<-- store the image in the directory
      //... store file name to database ...
}
//...