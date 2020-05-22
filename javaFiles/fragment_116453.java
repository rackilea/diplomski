public class TrainTrackServiceWrapper extends RemoteServiceServlet implements TrainTrackService { 

    @Autowired 
    private TrainTrackServiceImpl impl; 

    ...

    public UserDTO createUser(String firstName, String lastName, 
        String idNumber, String cellPhone, String email, int merchantId) { 

        return impl.createUser(firstName, lastName, idNumber, cellPhone, email, merchantId);
    }

}

public class TrainTrackServiceImpl implements TrainTrackService { 

    @Autowired 
    private DAO dao; 

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class) 
    public UserDTO createUser(String firstName, String lastName, 
       String idNumber, String cellPhone, String email, int merchantId) { 
        ...
    }
}