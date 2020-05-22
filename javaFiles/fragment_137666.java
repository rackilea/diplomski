BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
String line = "";

while (line.equalsIgnoreCase("q") == false) {
   line = in.read();

   System.out.println("Q is pressed!");
}

in.close();