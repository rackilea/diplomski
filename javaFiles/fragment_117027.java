myGenericInterfaceImpl = new Object();
// Generic type is supposed to be <String> int calcStuff(String)
myGenericInterfaceImpl.calcStuff = function(input) { 
        println("--- calcStuff called ---");
        println("input" + input);
        println("typeof(input):" + typeof(input));

        // do something with the String input
        println(input.charAt(0));
        return input.length();
    }