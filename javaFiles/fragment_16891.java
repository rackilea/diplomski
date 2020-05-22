Question name = new Question("What is your name?");
Question hobbies = new Question("What is your favorite hobby?");
Question dancing = new Question("What is your favorite dance?");
Question reading = new Question("What is your favorite book?");

name.setDefaultFollowup(hobbies);
hobbies.setDefaultFollowup(reading); // ask people about reading by default
hobbies.addFollowup("Dancing",dancing); // if they say they like dancing, ask that instead