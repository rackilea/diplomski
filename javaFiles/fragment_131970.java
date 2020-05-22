public class LegacyFileHandler {

    private final Map<Class<?>, Method> readMethods = createReadMethodMap();

    private final Map<Class<?>, Method> writeMethods = createWriteMethodMap();

    private Map<Class<?>, Method> createReadMethodMap() {
        Class<DataInput> clazz = DataInput.class;
        Class<?>[] noparams = {};
        try {
            Map<Class<?>, Method> map = new HashMap<Class<?>, Method>();
            map.put(Boolean.TYPE, clazz.getMethod("readBoolean", noparams));
            map.put(Byte.TYPE, clazz.getMethod("readByte", noparams));
            map.put(Character.TYPE, clazz.getMethod("readChar", noparams));
            map.put(Double.TYPE, clazz.getMethod("readDouble", noparams));
            map.put(Float.TYPE, clazz.getMethod("readFloat", noparams));
            map.put(Integer.TYPE, clazz.getMethod("readInt", noparams));
            map.put(Long.TYPE, clazz.getMethod("readLong", noparams));
            map.put(Short.TYPE, clazz.getMethod("readShort", noparams));
            return map;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    private Map<Class<?>, Method> createWriteMethodMap() {
        Class<DataOutput> clazz = DataOutput.class;
        try {
            Map<Class<?>, Method> map = new HashMap<Class<?>, Method>();
            map.put(Boolean.TYPE, clazz.getMethod("writeBoolean",
                    new Class[] { Boolean.TYPE }));
            map.put(Byte.TYPE, clazz.getMethod("writeByte",
                    new Class[] { Integer.TYPE }));
            map.put(Character.TYPE, clazz.getMethod("writeChar",
                    new Class[] { Integer.TYPE }));
            map.put(Double.TYPE, clazz.getMethod("writeDouble",
                    new Class[] { Double.TYPE }));
            map.put(Float.TYPE, clazz.getMethod("writeFloat",
                    new Class[] { Float.TYPE }));
            map.put(Integer.TYPE, clazz.getMethod("writeInt",
                    new Class[] { Integer.TYPE }));
            map.put(Long.TYPE, clazz.getMethod("writeLong",
                    new Class[] { Long.TYPE }));
            map.put(Short.TYPE, clazz.getMethod("writeShort",
                    new Class[] { Integer.TYPE }));
            return map;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    public int sizeOf(Object struct) throws IOException {
        class ByteCounter extends OutputStream {
            int count = 0;

            @Override
            public void write(int b) throws IOException {
                count++;
            }
        }

        ByteCounter counter = new ByteCounter();
        DataOutputStream dos = new DataOutputStream(counter);
        write(dos, struct);
        dos.close();
        counter.close();
        return counter.count;
    }

    public void write(DataOutput dataOutput, Object struct) throws IOException {
        try {
            Class<?> clazz = struct.getClass();
            for (Field field : clazz.getFields()) {
                Class<?> type = field.getType();

                if (type == byte[].class) {
                    byte[] barray = (byte[]) field.get(struct);
                    dataOutput.write(barray);
                    continue;
                }

                Method method = writeMethods.get(type);
                if (method != null) {
                    method.invoke(dataOutput, field.get(struct));
                    continue;
                }

                throw new IllegalArgumentException("Type "
                        + struct.getClass().getName()
                        + " contains unsupported field type " + type.getName()
                        + " (" + field.getName() + ")");
            }
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public void read(DataInput dataInput, Object struct) throws IOException {
        try {
            Class<?> clazz = struct.getClass();
            Object[] noargs = {};
            for (Field field : clazz.getFields()) {
                Class<?> type = field.getType();

                if (type == byte[].class) {
                    byte[] barray = (byte[]) field.get(struct);
                    dataInput.readFully(barray);
                    continue;
                }

                Method method = readMethods.get(type);
                if (method != null) {
                    Object value = method.invoke(dataInput, noargs);
                    field.set(struct, value);
                    continue;
                }

                throw new IllegalArgumentException("Type "
                        + struct.getClass().getName()
                        + " contains unsupported field type " + type.getName()
                        + " (" + field.getName() + ")");
            }
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

}