Pattern pattern = Pattern.compile("\\d{5}");
//Get your password from your user input in String password;
Matcher matcher = pattern.matcher(password)
if(matcher.find()){
    System.out.println("Password cannot have 5 numbers in sequence!");
}
//You can do the same with letters