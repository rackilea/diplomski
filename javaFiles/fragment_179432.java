private static final sun.misc.Unsafe UNSAFE;
static {
    Object result = null;
    try {
        Class<?> klass = Class.forName("sun.misc.Unsafe");
        for (Field field : klass.getDeclaredFields()) {
            if (field.getType() == klass &&
                (field.getModifiers() & (Modifier.FINAL | Modifier.STATIC)) ==
                    (Modifier.FINAL | Modifier.STATIC)) {
                field.setAccessible(true);
                result = field.get(null);
                break;
            }
        }
    } catch (Throwable t) {}
    UNSAFE = result == null ? null : (sun.misc.Unsafe)result;
}

private static final Field ADDRESS_FIELD;
static {
    Field f;
    try {
        f = Buffer.class.getDeclaredField("address");
        f.setAccessible(true);
    } catch (NoSuchFieldException | SecurityException e) {
        f = null;
    }
    ADDRESS_FIELD = f;
}


public static void absolutePut(ByteBuffer dstBuffer, int dstPosition, ByteBuffer srcBuffer) {
    if (!srcBuffer.isDirect()) {
        absolutePut(dstBuffer, dstPosition,
            srcBuffer.array(), srcBuffer.arrayOffset() + srcBuffer.position(),
            srcBuffer.remaining());
        return;
    }

    if (UNSAFE != null && ADDRESS_FIELD != null && dstBuffer.isDirect()) {
        try {
            long dstAddress = (long)ADDRESS_FIELD.get(dstBuffer) + dstPosition;
            long srcAddress = (long)ADDRESS_FIELD.get(srcBuffer) + srcBuffer.position();
            UNSAFE.copyMemory(srcAddress, dstAddress, srcBuffer.remaining());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    } else {
        // fallback to basic loop
        for (int i = srcBuffer.position(); i < srcBuffer.limit(); i++) {
            dstBuffer.put(dstPosition + i, srcBuffer.get(i));
        }
    }
}

public static void absolutePut(ByteBuffer dstBuffer, int dstPosition, byte[] src, int srcOffset, int length) {
    if (UNSAFE != null && ADDRESS_FIELD != null && dstBuffer.isDirect()) {
        try {
            long dstAddress = (long)ADDRESS_FIELD.get(dstBuffer) + dstPosition;
            UNSAFE.copyMemory(
                src, UNSAFE.arrayBaseOffset(byte[].class) + srcOffset,
                null, dstAddress,
                length);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    } else {
        // fallback to System.arraycopy
        System.arraycopy(
            src, srcOffset,
            dstBuffer.array(), dstBuffer.arrayOffset() + dstPosition,
            length);
    }
}