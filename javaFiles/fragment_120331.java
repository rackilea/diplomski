@Autowired
private Repository_Room repository;

public Form_Room() {
    repository = new Repository_Room_Impl(); //remove this line

    //rest of the code
}