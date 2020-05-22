String a = "1+5*2-4";
System.out.println(a);
String[] operator = a.split("[0-9]+");
String[] digits = a.split("[+-\\/*]");

final int[] index = {0};
int reduced = Stream.of(digits)
                    .mapToInt(Integer::parseInt)
                    .reduce(0, (int t, int u) -> 
{
    int result = Integer.parseInt(digits[0]);
    int i = index[0];
    if (operator[i].equals("+")) { result = t + u; } 
    else if (operator[i].equals("/")) { result = t / u; } 
    else if (operator[i].equals("*")) { result = t * u; } 
    else if (operator[i].equals("-")) { result = t - u; } 
    index[0]++;
    return result;
});