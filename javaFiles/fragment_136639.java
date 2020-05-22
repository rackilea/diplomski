public class InterfaceImpl implements MyInterface2{

    public Object SUM(Object O,Object P){
        //Really what can I do here without casting?

        /* If I have to cast, I might as well define
         types in the method signature, guaranteeing
         the type of the arguments
        */

       //Lets cast anyway
       return (Integer) O + (Integer) P;
    }

    public static void main(String[] args) throws ParseException {
       System.out.println(SUM(1,2));  //Excellent Returns 3
       //Yikes, valid arguments but implementation does not handle these
       System.out.println(SUM(true,false)); //Class cast exception          
    }
}