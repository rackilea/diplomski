import org.apache.openjpa.enhance.*;
import org.apache.openjpa.util.IntId;
import org.apache.openjpa.util.InternalException;

public class Entity implements PersistenceCapable
{  
    public Integer getId()
    {  
        return pcGetid(this);
    }
    public void setId(Integer id)
    {
        pcSetid(this, id);
    }
    ....
    .... 
    private static final void pcSetid(Entity entity, Integer integer)
    {  
        if(entity.pcStateManager == null)
        {  
            entity.id = integer;
            return;
        } else
        {  
            entity.pcStateManager.settingObjectField(entity, pcInheritedFieldCount + 3, entity.id, integer, 0);
            return;
        }
    }
    ....
    protected void pcClearFields()
    {  
        id = null;
    }

    public PersistenceCapable pcNewInstance(StateManager statemanager, Object obj, boolean flag)
    {  
        Entity entity = new Entity();
        if(flag)
            entity.pcClearFields();
        entity.pcStateManager = statemanager;
        entity.pcCopyKeyFieldsFromObjectId(obj);
        return entity;
    }
}