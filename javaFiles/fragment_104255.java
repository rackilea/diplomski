int sum = 0;
for(int i = 0; i < payroll.length; i++){
    for(int a = 0; a < payroll[i].length; a++){
       sum += payroll[i][a];
    }
}

System.out.println("the sum is: " + sum);