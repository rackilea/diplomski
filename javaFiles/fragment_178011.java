try {
    while ((inputLine = in.readLine()) != null) { 

        System.out.println ("received: " + inputLine); 
        out.println(inputLine); 

        if (inputLine.equals("Bye.")) 
            break; 

    } 
} catch (IOException ex) {
    System.out.println("Connection error... terminating.");
}