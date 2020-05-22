@Service
    public class ContractRepositoryImpl implements ContractRepositoryCustom {


        ContractRepository contractRepository;

        @Autowired
        EntityManager entityManager;


        public List allContractsByOwner(Long id) {
            List contracts = entityManager.createQuery(
                    "SELECT c FROM Contract c WHERE c.owner.id = :ownerId", Contract.class)
                    .setParameter("ownerId", id)
                    .getResultList();
            return contracts;
        }
    }