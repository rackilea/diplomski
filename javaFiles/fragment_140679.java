@ManagedBean
@ViewScoped
public class AjaxBacking {

Map<String, List<FacesMessage>> messages;

public AjaxBacking(){
    messages = new HashMap<String, List<FacesMessage>>();
}

public static AjaxBacking getCurrentInstance() {
    AjaxBacking ajaxBacking = null;
    FacesContext context = FacesContext.getCurrentInstance();
    if ((ajaxBacking = (AjaxBacking) context.getViewRoot().getViewMap().get("ajaxBacking")) == null){
        ajaxBacking = (AjaxBacking)context.getApplication().evaluateExpressionGet(context,"#{ajaxBacking}",AjaxBacking.class);
    }
    return ajaxBacking;
}

public void displayMessages(){
    FacesContext facesContext = FacesContext.getCurrentInstance();
    for (String component : messages.keySet()){
        for (FacesMessage message : messages.get(component)) {
            if (!facesContext.getMessageList(component).contains(message)){
                facesContext.addMessage(component, message);
            }
        }
    }
}

public void putMessages(String component, List<FacesMessage> facesMessage){
    List<FacesMessage> messages = new ArrayList<FacesMessage>();
    for (FacesMessage message : facesMessage) messages.add(message);
    this.messages.put(component, messages);
}

public Map<String, List<FacesMessage>> getMessages() {
    return messages;
}
}