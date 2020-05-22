Field[] fields=myClass.class.getDeclaredFields();
      for (int i=0; i != fields.length; ++i) {
        Field field=fields[i];
        Column info=field.getAnnotation(Column.class);
        if (info == null || field.getType() != String.class){
               continue;
              }
        System.out.println("Field Name : "+  field.getName() + "  Field type: " +field.getType().getSimpleName());
      }