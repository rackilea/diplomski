// Starting in main function after the System.out.println()

String name = scanner.nextLine();
scanner.close(); // optional but recommended

if (name == null || name.equals("") {
    // Do random pick as you did before and assign it to name
    String[] randoms = {"Luke", "Leia", "Sophia", "David"}; // Add all names here
    name = randoms[((int) Math.random()*randoms.length)]; // Pick random name
}

System.out.println("Your name is " + name);

// The rest of the class with closing brackets