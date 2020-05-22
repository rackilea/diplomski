@Component
public class FileU {

    FileWriter fw_output;

    @Autowired
    public FileU(@Qualifier("fileUInit") String s){

    }
}