int returnint = 0;
try {
    do {
        System.out.println ("If you want to exit the program, press 0. To continue, press 1.");
        if (!(returnint==1 || returnint==0)) {
            System.out.println ("Invalid response. Please retry.");
        }
        returnint = Input.nextInt();    
      continue;
    } while (returnint!=1 && returnint!=0);
} catch (Exception e) {
    System.out.println("ERROR: " + e.Message());
} finally {   
    System.out.println("Exit. Return value was set to " + returnint);
}