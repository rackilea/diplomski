public static void main(String[] args) throws Exception {
     Process child1 = Runtime.getRuntime().exec("cmd");
     int status1 = child1.waitFor();

     System.out.println("Exit status of child one: " + status1);

     // Something has gone wrong
     if (status1 != 0) {
         // end program
         return;
     }

     Process child2 = Runtime.getRuntime().exec("cmd2");
     int status2 = child2.waitFor();

     System.out.println("Exit status of child two: " + status2);
}