private void YesOrNo(String answer) {
    if (answer.toLowerCase.equals("yes")) {
        System.out.println("Alright here you go");
    } else if (answer.toLowerCase.equals("no")) {
    //↑ here!!!
        System.out.println("Alright fine");
    } else {
        System.out.println("Please type either yes, or no: ");
        run();
    }

}