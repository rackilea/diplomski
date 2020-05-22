if (int.class.equals(field.getType()) 
 {
   ...
 } 
 else if (field.getType().isArray() && byte.class.equals(field.getType().getComponentType()))
 {
   ...
 }