@RestController
@CrossOrigin("*")
public class PrestatairesRestController {
  @Autowired
  private PrestatairesRepository repository;

  @RequestMapping(value="/prestataires", method=RequestMethod.POST)
  // you don't have to add @RequestBody for the Prestataires
  public String postFileUpload(Prestataires prestataires, @RequestParam("multipartFile") MultipartFile file) {
    // Make sure that in the frontend the name of the form field for the file is also multipartFile
   // Also make sure that the mime type in the frontend is multipart/form-data

    byte[] rawFile;

    try {
      rawFile = file.getBytes();
    } catch (IOException e) {
      e.printStackTrace();
      return "error?";
    }

    prestataires.setFile(rawFile);

    prestatairesRepository.save(prestataires);

    return "redirect:/ or send response";
  }

}