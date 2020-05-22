char replacement = 'c';

String input = "aabbcc";
StringBuilder front = new StringBuilder(input.substring(0, input.length()/2));
// Do modulus to not include the odd middle (it mirrors itself)
StringBuilder back = new StringBuilder(input.substring((input.length()/2)+(input.length()%2));