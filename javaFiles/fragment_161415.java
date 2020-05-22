import java.sql.Timestamp;   

import com.db4o.Db4oEmbedded;   
import com.db4o.ObjectContainer;   
import com.db4o.ObjectSet;   
import com.db4o.config.EmbeddedConfiguration;   

public class dbTest {   

  public static void listResults(ObjectSet<Timestamp> results) {   

    for (Timestamp o : results) {   
      System.out.println(o);   
    }   
  }   

  public static void main(String[] args) {   

    EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();   
    config.common().objectClass(Timestamp.class).translate(new TSerializable());   
    ObjectContainer container = Db4oEmbedded   
        .openFile(config, "timestamps.db4o");   

    try {   

      long now = System.currentTimeMillis();   
      container.store(new Timestamp(now));   

      final ObjectSet<Timestamp> results = container.query(Timestamp.class);   
      listResults(results);   
    }   
    finally {   
      container.close();   
    }   
  }   
}