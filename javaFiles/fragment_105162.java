public String ProcessInput(String input){
  String output = null;
  String name = null;
  String X= null,Y = null;

  if (input.equals("connect")){
    System.out.println("Connection granted!");

      output =  Time + ":" + "Got a Connection over here!";
  }
  if (input.equals("Bye!")){
      System.err.println("Client said Bye!");
  }
  return output;
}