@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
@ResponseBody
public boolean uploadFiles(HttpServletRequest request, @RequestParam("files") MultipartFile[] files) {

    boolean transferSuccessful = true;

    for (MultipartFile file : files) {
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));

        String newFileName = genRandomName() + extension; //set unique name when saving on server
        File newFile;

        File imageFolder = new File(imageBasePath);
        //check if parent folders exist else create it
        if(imageFolder .exists() || imageFolder .mkdirs()) {
            while ((newFile = new File(imageFolder .getAbsolutePath() + "\\" + newFileName)).exists()) {
                newFileName = genRandomName(); //generate new name if file already exists
            }
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
                transferSuccessful = false;
            }
        } else {
            LOG.error("Could not create folder at " + imageFolder.getAbsolutePath());
            transferSuccessful = false;
        }
    }
    return transferSuccessful;
}