while (true){

        System.out.println("---Welcome to the Shape Machine---");
        System.out.println("Available options:");
        System.out.println("Circles");
        System.out.println("Rectangles");
        System.out.println("Triangles");
        System.out.println("Exit");
        //asks for selection
        String option = console.next();

        switch (option) {

        case "Circles": 
             //do something
              break;
        case "Rectangles":
              break;
        case "Triangles":
              break;
        case "Exit":
              break;
        default:
              System.err.println("#ERROR Invalid option. Please try again.");

        }
     //now you can either put a flag or change the code to a DO..While 
     //depending on if you want to re-execute after each option..

}