@Service
public class InvoiceService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Transactional
    public void createInvoice(Long invoiceId, Double totalAmount, Long userId) {
        User user = userRepository.findOne(userId);
        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setId(invoiceId);
        invoice.setTotalAmount(totalAmount);
        invoiceRepository.save(invoice);
    }
}