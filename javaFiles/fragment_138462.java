@Service("serviceAimpl") 
public class ServiceAImpl implements Service{ 
    public String doSomething(String param){ 
        return param + "A";
    }
}

@Service("serviceBimpl") 
public class ServiceBImpl implements Service{ 
    public String doSomething(String param){
        return param;
    }
}
@Service("mainService")
public class ServiceImpl {
    @Autowired
    private ServiceAImpl serviceAimpl;
    @Autowired
    private ServiceBImpl serviceBimpl;

    public String doSomething(String param) {
         if(param.startsWith("1")
             return this.serviceAimpl.doSomething(param);
         else
             return this.serviceBimpl.doSomething(param);
    }
}