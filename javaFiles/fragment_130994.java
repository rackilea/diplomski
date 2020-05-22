Person person1 = new Person();        // Creates a Person instance
person1.setAge(10);                   // Sets person1's age to 10

Person person2 = new Person();        // Creates a separate Person instance
person2.setAge(person1.getAge());     // Sets person2's age to 10

person1.setAge(30);                   // Sets person1's age to 30; no effect on person2

System.out.println(person2.getAge()); // Shows person2's age (10)