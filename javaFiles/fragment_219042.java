@Converter(autoApply = true)
public class JsonListConverter implements AttributeConverter<SomeAbstractClass, String> {
@override
public String convertToDatabaseColumn(SomeAbstractClass sac){
// Your implementation goes here
}
@override
public SomeAbstractClass convertToEntityAttribute(String s){

    //check to find if s can be SomeClass1
    if(checkSomeClass1(s)){ 
 // return an instance of SomeClass1
}
    else{
// return an instance of SomeClass2
}


}
}