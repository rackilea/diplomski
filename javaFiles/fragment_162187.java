@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Transactional
    public void addClient(Client client){
        clientRepository.saveAndFlush(client);
    }
}