@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void addClient(Client client){
        clientRepository.saveAndFlush(client);
    }
}