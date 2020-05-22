public void validateRange(String fieldname, int input) 
    {
        Field[] fields = this.getClass().getDeclaredFields();

        for(Field field: fields)
        {

            if(field.getName().equals(fieldname)){
            if (field.isAnnotationPresent(Range.class))

            {

                Range range = field.getAnnotation(Range.class);
                int max = range.max();
                int min = range.min();
                if ( ( input <= max ) && (input >= min) )
                {
                    System.out.println("Value in range");
                }
                else
                {
                    System.out.println("Value is not in range");
                }

            }
            }
        }
    }