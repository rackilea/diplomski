public class GUI() 
{
    this.handler = new Handler(this);
    this.logic = new Logic(this);
    handler.setLogic(logic);
    logic.setHandler(handler);
}