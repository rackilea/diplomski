// Find the index corresponding to the smallest salary
int index = -1;
for(int i=0; i<salaryArray.length; i++){
    if(salaryArray[i] == smallestSalary){
        index = i;
    }
}