String something = "123e45,j, _122";
int length = something.length();
int result = 0;
for (int i = 0; i < length; i++) {
    Character character = something.charAt(i);
    if (Character.isDigit(character)) {
        result += Character.getNumericValue(character);
    }
}
System.out.println("result is: "+result);