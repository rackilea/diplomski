@Service
public class MyService {
    @Autowired
    MyAsyncService myAsyncService;
    public worker(){
        myAsyncService.asyncJob();
    }
}

@Service
public class MyAsyncService {

    @Async
    public asyncJob(){ // switched to public
        ...
    }

}