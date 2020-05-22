StringBuilder resultBuilder = new StringBuilder();
for (int k = 0; k < (stack.length-1); k++) {
   resultBuilder.append(stack[k]);
   if (Character.isLetter(stack[k]) && Character.isLetter(stack[k+1])) {
     resultBuilder.append('*');
  }
}
resultBuilder.append(stack[stack.length-1]);  // don't forget the last element