System.out.println("Initialize complete");
System.out.println(table.getDefaultEditor(Object.class));
System.out.println(table.getDefaultEditor(CustomClass.class));

Class[] argTypes = new Class[]{String.class};
java.lang.reflect.Constructor constructor;
//Class<?> type = table.getColumnClass(column);
Class<?> type = CustomClass.class;

//String s = (String)super.getCellEditorValue();
String s = "25";

try
{
    //SwingUtilities2.checkAccess(constructor.getModifiers());
    constructor = type.getConstructor(argTypes);
    Object value = constructor.newInstance(new Object[]{s});
    System.out.println(value + " : " + value.getClass());
}
catch (Exception e)
{
    System.out.println(e);
    //((JComponent)getComponent()).setBorder(new LineBorder(Color.red));
    //return false;
}