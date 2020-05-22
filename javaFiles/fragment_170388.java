public boolean copyIfNull(Object o)
{

        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields)
        {
        try {
            Object fieldValue = field.get(this);
            if (fieldValue == null)
            {
                field.set(this, field.get(o));
                return false;
            }
        }

        catch (Exception e) {
            System.err.println("Field value could not be obtained");
            e.printStackTrace();
            return false;
        }
        }


    return true;

}