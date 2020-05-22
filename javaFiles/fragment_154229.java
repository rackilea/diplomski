Character one=(char) myStack.pop();
Character two=(char) myStack.pop();

String str1 = Character.toString(one);
String str2 = Character.toString(two);

double first=Double.parseDouble(numbers.get(str1));
double second=Double.parseDouble(numbers.get(str2));
double temp=first+second;
myStack.push(temp);