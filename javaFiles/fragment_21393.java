@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ClientDao clientDao;

    @Override
    @Transactional
    public void startImport() {
        // Process...
    }