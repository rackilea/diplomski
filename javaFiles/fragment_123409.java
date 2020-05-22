public static void main(String[] args){
    //simulating user input as array
    String simulatedUserInput[] = {"apple",
                                   "pie"};

    InputStream savedStandardInputStream = System.in;   //to reset
    //----

    addMsg(simulatedUserInput);

    //reset
    System.setIn(savedStandardInputStream);
}

//function to affect
public static void addMsg(String[] simulatedUserInput)
{
    String msg = "";
    // Loop over the input array and provide the input
    for (int i = 0;i < simulatedUserInput.length; ++i) {
        System.setIn(new ByteArrayInputStream(simulatedUserInput[i].getBytes()));
        msg += inputOutput("Enter message " + (i + 1)) + " ";
    }
    // output the input
    System.out.println(msg);
}