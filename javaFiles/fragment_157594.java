string SomeMethodCreatingAString()
{
   StringBuilder sb = new StringBuilder();
   sb.append("more text to add");
   sb.append("more text to add");
   sb.append("more text to add");
   sb.append("more text to add");
   sb.append("more text to add");
   MethodThatCreatesAnotherString(sb);
   // more text
   return sb.ToString();
}