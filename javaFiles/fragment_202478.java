for(i=0;i<empDetString.length;i++){

    if(input.equals(empDetString[i][0])) {
        System.out.println("Employee number:"+ empDetString[i][0]);
        System.out.println("Surname: "+ empDetString[i][1]);
        System.out.println("First name: "+empDetString[i][2]);
        System.out.println("Position: "+empDetString[i][3]);
        System.out.println("Salary: "+empDetString[i][4]);
        System.out.println("% Attendance: "+empDetString[i][5]);
        System.out.println("Casual Leaves Left: "+empDetString[i][6]);
        System.out.println("Sick leaves left: "+empDetString[i][7]);
        break;
    }
}