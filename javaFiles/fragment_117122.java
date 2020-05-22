@Service
public class AmendmentService {

    @Autowired
    private AmendmentRepository amendmentRepository;

    public boolean persistAmendments(int _cutsheetId) {
        boolean persistSuccessful = true;
        try {
            amendmentRepository.persistAmendments(_cutsheetId);
        } catch (RuntimeException e) {
            persistSuccessful = false;
        }
        return persistSuccessful;
    }
}