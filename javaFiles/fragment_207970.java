@PersistenceCapable
public class ConcretePersistentObject extends PersistentObject {
    /** Case 1 - Stored and retrieved fine */
    @Persistent 
    private String name;

    /** Case 2 - A new object ref is visible in the debugger for this after the call to makePersistent , but when retrieved it's null */
    @Persistent(defaultFetchGroup="true") 
    private Map<String, String> taskToCommandMap;

    /** Case 3 -  DataSelection is serializable */
    @Persistent(defaultFetchGroup="true")
    private Map<String, Map<String, DataSelection>> taskToDefaultCommandParams;

    /** Case 4 - Serialized because GAE doesn't support persisting Map values of type LinkedList or ArrayList. 
     */
    @Persistent(serialized="true", defaultFetchGroup="true")
    private Map<String, List<String>> taskToTransitions;

    // getters and setters omitted