public static <Type> Type get_element(int index)
{
    String s = list.get(index).getClass().toString(); // returns "class class_name"
    String[] split = s.split(" ");
    Class<?> theClass = Class.forName(split[1]); // You need "class_name"

    return (Type) theClass.cast(list.get(index));
}