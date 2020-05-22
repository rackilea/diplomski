System.out.println("Pick a medium (1, 2, or 3):\n1. Air\n2. Water\n3. Steel");
user_Choice = kbReader.nextInt();
kbReader.nextLine(); //Consumes the \n (new line) character.
System.out.print("Enter the distance the sound wave traveled in feet: ");
distance = kbReader.nextDouble();
SpeedOfSound speed = new SpeedOfSound(distance);