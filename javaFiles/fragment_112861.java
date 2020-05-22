@Service
public class JobInvoiceServiceImpl implements JobInvoiceService {

    @Autowired
    private CustomJobInvoiceRepository jobInvoiceRepository;

    @Override
    public List<JobInvoiceBean> getAllJobInvoice() {
        return jobInvoiceRepository.getAllInvoices();
    }

}