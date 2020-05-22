public Pane() {
     try {
        Scanner read = new Scanner(new File("user.txt"));

        if (read.nextInt() != 0) {
           Test.startGUI2();

           // ********** two lines below added ******
           System.out.println("gui1 null? " + (Test.getGUI1() == null));
           System.out.println("frame null? " + (frame == null));

           Test.getGUI1().frame.dispose();
        }
     } catch (FileNotFoundException ex) {
        Logger.getLogger(GUI1.class.getName()).log(Level.SEVERE, null, ex);
     }