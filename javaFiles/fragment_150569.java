@Named
@SessionScoped
public class CancelListener implements Serializable, javax.faces.event.ActionListener {

    @Inject
    private LoginBean loginBean;

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        System.out.println(this.toString());
        System.out.println(loginBean.toString());
    }        
}