@Alternative
@RequestScoped
public class MyMessages extends MessagesImpl {

/*
 * Override a method that you want to customize or write new code here
 */
@Override
public Set<Message> getAll() {
    Set<Message> allMessages = super.getAll();

    // do some custom logic here
    applyOverrides(allMessages);

    return allMessages;
}
...
// override any other method as needed 
// You will probably have to override everything so it probably 
// wouldnt make sense to extend the existing implementation)
...
}