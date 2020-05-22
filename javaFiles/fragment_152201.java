System.out.println("Input name, gender, amt:");
input = scn.nextLine();
String[] token = input.split(" ");
String name = token[0];
String gender = token[1];
double amt = Double.parseDouble(token[2]);

Customer c1 = new Customer (name,gender, amt);