Class<?> cls = Class.forName(type);
//Get a converter method, String to  type
//Requires static method valueOf
Method converter;
try{
converter = cls.getDeclaredMethod("valueOf",new Class[]{String.class});
}catch(NoSuchMethodError ex){
   //No conversion method found
   return false;
}
if(!Modifier.isStatic(converter.getModifiers()){
   //the method has to be static in order to be called by us
   return false;
}
if(!cls.isAssignableFrom(converter.getReturnType())
    //The conversion method has the wrong return type
    return false;
try{
    //try to parse the value
    Object o = converter.invoke(null,new Object[]{value};
    if( o == null)return false;//false if method returned null
    else return true;//success
}catch(Exception ex)
{
    //could not parse value
    return false;
}