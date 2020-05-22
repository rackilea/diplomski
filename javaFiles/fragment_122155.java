import java.io.ByteArrayInputStream;
    import java.io.ByteArrayOutputStream;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Set;

    public class SerializeUtil {

        /**
         * unserialize byte[]
         * @param bytes
         * @return Object
         */
        public static Object unserialize(final byte[] bytes) {
            ByteArrayInputStream bais = null;
            try {
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            } catch (Exception e) {

            } 
            return null;
        }

        /**
         * unserialize hash Map<byte[], byte[]>
         * @param hash
         * @return Map<Object, Object>
         */
        public static Map<Object, Object> unserializehmbb2moo(final Map<byte[], byte[]> hash) {
            Map<Object, Object> result = new HashMap<Object, Object>();
            try {
                Set<byte[]> keys = hash.keySet();
                if (keys != null && keys.size() > 0) {
                    for (byte[] key : keys) {
                        result.put(unserialize(key), unserialize(hash.get(key)));
                    }
                }
            } catch (Exception e) {
            }
            return result;
        }


        /**
         * unserialize hash Map<byte[], byte[]>
         * @param hash
         * @return Map<String, Object>
         */
        public static Map<String, Object> unserializehmbb2mso(final Map<byte[], byte[]> hash) {
            Map<String, Object> result = new HashMap<String, Object>();
            try {
                Set<byte[]> keys = hash.keySet();
                if (keys != null && keys.size() > 0) {
                    for (byte[] key : keys) {
                        result.put(unserialize(key).toString(), unserialize(hash.get(key)));
                    }
                }
            } catch (Exception e) {
            }
            return result;
        }
    }