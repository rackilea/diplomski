Person person1 = new Person();
Home home1 = new Home();
Job job1 = new Job();

person1.setHome(home1);
home1.setOwner(person1);
person1.setJob(job1);
job1.setOnwer(person1);