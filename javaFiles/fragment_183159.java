String userInput = "3+5";
List<Character> numbers = new ArrayList<>();
List<Character> operators = new ArrayList<>();
for (char c : userInput.toCharArray()) {
  if(Character.isDigit(c)){
    numbers.add(c);
  }
  else{
    operators.add(c);
  }
}
// Now loop through lists and perform the desired arthimetic operation based on operator