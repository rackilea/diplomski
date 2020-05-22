@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = "multipart/form-data")
public Object uploadProducts(@RequestParam("file") MultipartFile file,HttpServletRequest request) {

    try {
        Session session = request.getSession();
        UploadCreate uploadCreate = new UploadCreate();
        uploadCreate.setName(file.getOriginalFilename());
        uploadCreate.setContentType(file.getName());
        uploadCreate.setContent(file.getBytes());
        uploadCreate.setUploadedDate(new Date());
        uploadService.uploadProducts(uploadCreate);
        List<UploadCreate> fileList =     
        (List<UploadCreate>)session.getAttribute("list");
        if(fileList==null){
          fileList = new ArrayList<UploadCreate>();
        }
        fileList.add(uploadCreate);
        session.setAttribute("list",fileList);

        return new ModelAndView("product/upload")
                .addObject("error", "Product upload scheduled.");
         //the method addObject() means to add data into request ; 
         //and the previous request and current request can not share the same data ;


    } catch (Exception e) {
        return new ModelAndView("product/upload").addObject("error", e.getMessage());
    }
}