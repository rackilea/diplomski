class SalaryCalculate{
    public static void main(String args[]){
    int totalJobs,jobcounter,maxSalary,minSalary,averageSalary=0;;
    int[] jobsincome;
    String name;
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter your name");
    name=sc.nextLine();
    System.out.println("How many jobs you had");
    totalJobs= sc.nextInt();
    jobsincome= new int[totalJobs];
    for(int i=0;i<totalJobs;i++){
        jobcounter=i+1;
        System.out.println("Enter the income for your job "+jobcounter);
        jobsincome[i]=sc.nextInt();
        averageSalary=averageSalary+jobsincome[i];
    }
    jobsincome=average(jobsincome);
    maxSalary=jobsincome[totalJobs-1];
    minSalary=jobsincome[0];
    averageSalary=averageSalary/totalJobs;
    System.out.println("Hi "+name+" your min salary is "+minSalary+" max salary is "+maxSalary+" average salary is "+averageSalary);
    }
    public static int[] average(int jobsincome[]){
        int length=jobsincome.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(jobsincome[i]>jobsincome[j]){
                    int temp=jobsincome[j];
                    jobsincome[j]=jobsincome[i];
                    jobsincome[i]=temp;
                }
            }
        }
        return jobsincome;
    }
    }