@EJB
private PersonenstammFacade personenstammFacade;

....

List <Personenstamm> personlist;
personlist = personenstammFacade.findAll();

....
//do what you want with this list