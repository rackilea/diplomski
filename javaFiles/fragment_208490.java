System.out.println("1234567890".matches("[A-Za-z0-9]{10}|[A-Za-z0-9]{12}|[A-Za-z0-9]{25}")); 
// => true, 10  Alnum characters
System.out.println("12345678901".matches("\\p{Alnum}{10}|\\p{Alnum}{12}|\\p{Alnum}{25}"));
// => false, 11 Alnum characters
System.out.println("123456789012".matches("\\p{Alnum}{10}|\\p{Alnum}{12}|\\p{Alnum}{25}"));
// => true, 12  Alnum characters