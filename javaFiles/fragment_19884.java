String propName;
Enumeration<String> props = msg.getPropertyNames("%");
if (props != null)
{
   while (props.hasMoreElements())
   {
      propName = props.nextElement();
      System.out.println("---> propName="+propName+" : " + "value="+msg.getObjectProperty(propName));
   }
}