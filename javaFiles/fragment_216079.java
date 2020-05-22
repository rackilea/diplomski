for (int i = 0; i < dna.length(); i++) {
  char c = dna.charAt(i);        
  if (c == 'C' || c == 'G') { 
    count++;
  }
}
return (double)count / dna.length();