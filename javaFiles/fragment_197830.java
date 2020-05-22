int evenCount = 0;
int oddCount = 0;

for(int item: randomEight){
   //Use modulo to determine even vs odd
   if(item % 2 == 0){
       evenCount++;
   } else {
       oddCount++;
   }
}