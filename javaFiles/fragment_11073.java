public class Test {

    Object testVariable;

    {
        String whichType = null;

        //Logic to read your system variable from wherever and store it in whichType

        if(whichType.equals("int")) {
            testVariable = new Integer(intVal);
        }
        else if(whichType.equals("double")) {
            testVariable = new Double(doubleVal);
        }
        //etc.
    }