for (Field field : bean.getClass().getDelcaredFields())
{
  if (field.getAnnotation(Autowired.class) != null)
  {
    boolean wasAccessible = field.isAccessible();

    try
    {
      field.setAccessible(true);
      field.set(bean, findSuitableValueByType(field.getType())); 
    }
    finally
    {
      field.setAccessible(wasAccessible);
    }  
  }
}