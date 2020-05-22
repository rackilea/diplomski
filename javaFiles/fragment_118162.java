public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int numStudents = sc.nextInt();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int total = 0;
    for (int i=0; i<numStudents; i++){
        int grade = sc.nextInt();
        max = Math.max(max, grade);
        min = Math.min(min, grade);
        total += grade;
    }
    double average = total/numStudents;
    //Your menu will be specific to you. It will need to go here and return 
    //average, min, or max

}