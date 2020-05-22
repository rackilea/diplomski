@Service
public class FilerService {
    @PostRemove 
    @Async
    void deleteFile(MyDocument document) {
        Files.deleteIfExists(Paths.get(document.getFilePath()));
    }
}