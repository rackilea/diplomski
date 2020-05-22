Object array = new int[10][][][];
Class<?> type = array.getClass();
while (type.isArray())
{
    type = type.getComponentType();
}
assert type == Integer.TYPE;