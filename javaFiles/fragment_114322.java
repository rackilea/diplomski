String message = "Han hannibal@domain.com im 20 years old, i just came here to say nothing..";
Pattern pattern = Pattern.compile("\\b[A-Za-z0-9+_.-]+@(?:[^.\\s]+\\.)+\\w{2,4}\\b");
Matcher m = pattern.matcher(message);
if(m.find())
{
    System.out.println("TAG " + m.group());
}

else {
    System.out.println("TAG " + "No email found on string");
}