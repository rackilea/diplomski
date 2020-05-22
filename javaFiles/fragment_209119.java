@RequestMapping(value = "/showImage/{saloonName}/{folder}/{hairstyleName}/{imageName}", method = RequestMethod.GET)
@ResponseBody
public void getImage(@PathVariable(value = "saloonName") String saloonName,
                     @PathVariable(value = "folder") String folder,
                     @PathVariable(value = "hairstyleName") String haistyleName,
                     @PathVariable(value = "imageName") String imageName, HttpServletResponse response) throws IOException {

    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    try {
        InputStream is = new FileInputStream("C:\\Database" + File.separator + saloonName +
                File.separator + folder + File.separator + haistyleName + File.separator + imageName + ".jpg");
        IOUtils.copy(is, response.getOutputStream());
    } catch (IOException e) {
        System.out.println("Couldn't open image from " + "C:\\Database\\" + saloonName + "\\" + folder + "\\" + haistyleName + "\\" + imageName + ".jpg");
    }
}