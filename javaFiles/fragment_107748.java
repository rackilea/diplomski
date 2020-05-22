String s = input.toLowerCase();
Boolean b ;
if ("true".equals(s) || "false".equals(s)) {
   b= Boolean.parseBoolean(s);
}
else  {
    throw new InvalidInputException("true or false is allowed");
}