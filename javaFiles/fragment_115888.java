class PathConverter extends javax.persistence.AttributeConverter<Path, String>{

     @Override 
     public String convertToDatabaseColumn(Path path){
         return /* your convert operation from path to string */;
     }

     @Override 
     public Path convertToEntityAttribute(String string){
         return /* your convert operation from string to path */;
     }
}