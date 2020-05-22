String result = "";

if (i % 3 == 0)   result = "Fizz";
if (i % 5 == 0)   result += "Buzz";
if (result == "") result += i;

System.out.println(result);