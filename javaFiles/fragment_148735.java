Method writeMethod = dpv.getWriteMethod();    
JButton button = ...; // the target to write to

try
{
   writeMethod.invoke(button, 42);
}
catch (IllegalAccessException ex)
{
  // handle these as appropriate
}
catch (IllegalArgumentException ex)
{
}
catch (InvocationTargetException ex)
{
}