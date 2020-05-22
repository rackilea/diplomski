@Autowired UserNumRepository userNumRepository;

public void run(String... args) throws Exception {

    userNumRepository.deleteAll();
    // start the sequence at 9000
    userNumRepository.save(new UserNum(9000)); 
}