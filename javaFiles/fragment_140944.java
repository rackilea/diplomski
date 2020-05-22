while (idLoopTrigger == true) {

    try {
        System.out.println("Please enter id: ");
        id = in.nextLine();
        setId(id);
        idLoopTrigger = false;

    } catch (Exception ex) {

        //print this error message out
        System.out.println(ex.getMessage());
    }

}