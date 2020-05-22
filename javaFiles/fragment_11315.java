Person.java
import java.util.Set;
import com.google.appengine.api.datastore.Key;

// ...
    @Persistent
    private Set<Key> favoriteFoods;
Food.java
import java.util.Set;
import com.google.appengine.api.datastore.Key;

// ...
    @Persistent
    private Set<Key> foodFans;