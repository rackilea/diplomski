public static void calculateAverage (int grade[][]){

    ArrayList<Double> averageGrades = new ArrayList<Double>();
    int sum = 0;

    for(int student = 0; student < grade.length; student++){
    for(int i = 0; i < grade[student].length; i++){

        if(i == 0){
            sum = grade[student][i];
        }else if(i == grade[student].length - 1){

            sum += grade[student][i]; //Add next grade to sum

            averageGrades.add((double) (sum/i)); //Divide the sum by the number of grades (average)

        }else{

        sum += grade[student][i]; //Add next grade to sum

        }

    }
}

    for(int counter = 0; counter < averageGrades.size(); counter++){
        //Cycle through the grades and print them after the student name (grade[counter])
        System.out.println(grade[counter] + " " + averageGrades.get(counter));

    }



  }