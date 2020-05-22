@Controller
@RequestMapping(value = "/rest")     
public class AppRestController {

    @RequestMapping(value= "/upload-metadata",  method = RequestMethod.POST)
    public @ResponseBody Boolean uploadMetadata(@RequestBody MetadataForm metadataForm){
        Logger.info("uploading metadata : {0}", metadataForm.getTitle());
        return true;
    };