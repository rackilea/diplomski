import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.pool.*;

KryoFactory factory = new KryoFactory() {
  public Kryo create () {
    Kryo kryo = new Kryo();
    // configure kryo instance, customize settings
    return kryo;
  }
};
// Build pool with SoftReferences enabled (optional)
KryoPool pool = new KryoPool.Builder(factory).softReferences().build();