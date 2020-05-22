public class Database2 implements Database<SomeObject> { 
    @Override
    public SomeObject createNode(...) { 
        ...
        SomeObject result = // obtain id of created node
        return result;
    }

    @Override
    public void modifyNode(SomeObject id, ...) { 
        ...
        // use id as (SomeObject)id
    } 
}