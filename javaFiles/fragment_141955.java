while(!stack.empty( )) {
  char c = stack.pop( );

  if (c != s.charAt(i)) {
    return false; 
  }

  i++;
}