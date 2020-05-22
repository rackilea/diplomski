StringBuilder b = new StringBuilder (s.length()+estimated_expansion);
// this estimate doesn't have to be correct, but if it is high enough 
// without being *much* too high performance is optimized
for(int i = 0; i < array.length; i++ ){
  b.append(tokens[i]).append(array[i]);
}
s = b.append(tokens[array.length]).toString();