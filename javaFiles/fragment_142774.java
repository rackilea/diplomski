static int size = 10;
int compiledList;
IntBuffer lists;

lists = BufferUtils.createIntBuffer(size);
compiledList = GL11.glGenLists(size);

for (int i = 0; i < size; i++) {
    GL11.glNewList(compiledList + i, GL11.GL_COMPILE);
    ...render here...
    GL11.glEndList();
    lists.put(offset);
}
lists.flip();

GL11.glListBase(compiledList);
GL11.glCallLists(lists);