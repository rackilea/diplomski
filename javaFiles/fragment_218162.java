boolean selectPositiveNumber = .....; // obtained somehow through user input
int[] numbers = null;
if(positiveNumbers){
     numbers = getAllPositiveNumbers(allNumbers);
} else {
     numbers = getAllNegativeNumbers(allNumbers);
}