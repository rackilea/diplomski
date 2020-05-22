for(char c : A) HashMapA[c]++;

start = 0
for(int end = 0; end < B.length(); end++) {
  char c = B[end];
  HashMapB[c]++;
  while(HashMapB[c] > HashMapA[c] && start <= end) {
    HashMapB[ B[start] ]--;
    start++;  
  }
  if(end - start + 1 == A.length())
    return true;
} 

return false;