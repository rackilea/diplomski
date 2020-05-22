bool check(int arr[], int idx, int mod10, int odd2,  int size){ 

  if(idx == size){

     return (mod10 == 0 and odd2 == 1);
}

   // include current element in group A

  bool first_choice = check(arr, idx + 1, (mod10 + arr[idx]) % 10, odd2, size)

   // include  current element in group B

  bool second_choice = check(arr, idx + 1, mod10, (odd2 + arr[idx]) % 2, size)

  return (first_choice or second_choice);    
}