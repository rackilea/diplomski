void getdata() {  // Method starts
    try { // try starts
        a = Integer.valueOf(input.readLine()).intValue();
        b = Integer.valueOf(input.readLine()).intValue();
        c = Integer.valueOf(input.readLine()).intValue();
    } // try ends

    catch (Exeption e) { // catch for the try starts
        System.out.println(" IO ERROR ");
    } // catch ends
} // method ends