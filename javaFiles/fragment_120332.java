@Route(value = "rooms")
public class View_CRUD_Room extends VerticalLayout implements Reloader {

@PostConstruct
private void init(){
    form = new Form_Room(); //remove this line

    //rest of the code
}