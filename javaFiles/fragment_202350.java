String typeName = JOptionPane.showMessageDialog(null, "Enter a type");
Class<?> class = Class.forName(typeName);
if (class != null && class.isInstance(boat1))
{
    System.out.println("boat1 is a motorboat");
}