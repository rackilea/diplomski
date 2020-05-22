String[][] courses = new String[length][4];

System.out.println("Follow this model when entering your courses: ENG-105-3-A");

for(int counter = 0; counter < length; counter++){
    System.out.println("Course "+(counter+1));

    //Solution
    courses[counter] = input.next().split("-");  //data are separated by "-"

    input.nextLine(); //Cleanning buffer

}