Field[] oldFields = oldInstance.class.getDeclaredFields();
    Field[] newFields = newInstance.class.getDeclaredFields();
    StringBuilder changes = new StringBuilder();

    Arrays.sort(oldFields);
    Arrays.sort(newFields);

    int i = 0;
    for(Field f : oldFields)
    {
       if(!f.equals(newFields[i]))
       {
          changes.append(f.getName()).append(" has changed.\n");
       }
       i++;
    }