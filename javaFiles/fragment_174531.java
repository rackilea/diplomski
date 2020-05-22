String test = "employee.first_name 2 * ... employee.salary AS double_salary blabla e.s blablabla";
// searching for a number of word characters or puctuation, followed by dot, 
// followed by a number of word characters or punctuation
// note also we're avoiding the "..." pitfall
Pattern p = Pattern.compile("[\\w\\p{Punct}&&[^\\.]]+\\.[\\w\\p{Punct}&&[^\\.]]+");
Matcher m = p.matcher(test);
while (m.find()) {
    System.out.println(m.group());
}