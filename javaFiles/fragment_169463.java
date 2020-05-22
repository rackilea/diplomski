for (int i = 0; i < myDouble.length; ++i) {
    int count = 0; // count the values used to calculate sum
     int sum = 0;
     int average = 0;
    for (int j = 0; j < myDouble[i].length; ++j) {
        if(myDouble[i][j] == null) //skip the null values
            continue;
        //Arrays.sort(myDouble[i]);
        sum+=myDouble[i][j];
        count++;
        System.out.print(App.myDouble[i][j] + " ");
    }
    average = (sum/count); //use count instead of lenght

    System.out.println(" ");
    System.out.println(average);
}