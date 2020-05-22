@Service
public class Service1 {

    @Autowired
    private Service2 service2;

    @Transactional(rollbackFor=Exception.class)
    public void test1(Account account) throws Exception {
        DOA.save(account);
        status = service2.test2(account);
        if(status!='SUCCESS'){
            throw new Exception("Api call failed");
        }
    }
}

@Service
public class Service2{

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void test2(Account account) {
        response // API Call
        DOA.save(response);
        return response.status;
    }
}