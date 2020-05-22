@EJB
UntitledFacade facade;
Untitled untitled;

/** Creates a new instance of untitledController */
public untitledController() {
}

@PostConstruct
public void init() {
    // create the entity object to be used 
    untitled = new Untitled();
}

public Untitled getSelected() {
    if (untitled == null) {
        System.out.println("created a new object");
        return new Untitled();
    } else {
        System.out.println("will return old object");
        return untitled;
    }
}
public String create() throws Exception {
    try {
        System.out.println("will persist object");
        System.out.println("and your object is" + untitled);
        facade.create(untitled);
        return "success";
    } catch (Exception e){
        System.out.println("fail at persisting the entity");
        e.printStackTrace();
        return "fail";
    }
}