for (Field f : TestEnum.class.getDeclaredFields())
{
    if (!Modifiers.isStatic(f.getModifiers())
    {
        f.setAccessible(true);
        f.set(o, f.get(TestEnum.INSTANCE));
    }
}