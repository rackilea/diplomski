public static void detach(Target target) {
    GL.glBindBuffer(target, 0);
}

public static void detach(BufferObject bufferObject) {
    detach(bufferObject.getTarget());
}