@Component
public class FileU {

    FileWriter fw_output;

    @Autowired
    @Qualifier("fileUInit")
    private String s;

    public FileU(){

    }
}