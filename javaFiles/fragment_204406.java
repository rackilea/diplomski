package models.test;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class FooSystem extends Model
{
    @ElementCollection
    private Map<Long, Foo> fooMap = new HashMap<Long, Foo>();

    public FooSystem()
    {
    }

    public Map<Long, Foo> getFooMap()
    {
        return fooMap;
    }

    public void put(Long l, Foo f)
    {
        fooMap.put(l, f);
    }
}