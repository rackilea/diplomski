RequestMapping(value = "/yourPath", method = RequestMethod.POST)
public @ResponseBody Object upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
    //Get your form fields...
    final String ID= request.getParameter('ID');
    //and so on......

    //Get your files.
    Iterator<String> iterator = request.getFileNames();
    MultipartFile multipartFile = null;
    while (iterator.hasNext()) {
        multipartFile = request.getFile(iterator.next());
        //do something with the file.....
    }
}