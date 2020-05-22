while (year > years) {

    //predict = salary * (pi/100); commented this because it is not necessary anymore.
    salary += salary * (pi/100);

    System.out.println(years + ". " + salary); // replaced predict with salary, to show their salary and not just their predicted raise.
    years++;

    // This block of code will never be hit, therefore it is not needed.   
    //if (years == year){
    //    break;
    //}
}