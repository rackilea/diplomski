import org.apache.commons.pool.BasePoolableObjectFactory; 

public class StringBufferFactory extends BasePoolableObjectFactory<StringBuffer> { 
    // for makeObject we'll simply return a new buffer 
    public StringBuffer makeObject() { 
        return new StringBuffer(); 
    } 

    // when an object is returned to the pool,  
    // we'll clear it out 
    public void passivateObject(StringBuffer buf) { 
        buf.setLength(0); 
    } 

    // for all other methods, the no-op  
    // implementation in BasePoolableObjectFactory 
    // will suffice 
}