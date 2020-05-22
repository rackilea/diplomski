class Job{
  public String name;
  public float salary;
  public float multiplier;

  public Job(String name, float salary, float multiplier){
    this.name=name;
    this.salary=salary;
    this.multiplier=multiplier;
  }
}

//On Main
Job banker = new Job("Banker", 9000, 1);
Job seniorBanker = new Job("Senior Banker", 9000, 1.2f);
Job plumber = new Job("Plumber", 800, 1);

//...
//Assuming citizen class contains Job variable: public Job job;
Citizen jack = new Citizen(); 
jack.job = banker;
Citizen mario = new Citizen(); 
mario.job = plumber;
Citizen luigi = new Citizen(); 
luigi.job = plumber; //Same instance of 'plumber' as mario's...
//If you change the value of the plumber's job salary, and then do...
  //system.out.println(mario.job.salary);
  //system.out.println(luigi.job.salary);
//...both will be changed.