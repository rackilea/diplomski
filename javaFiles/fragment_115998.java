public Company()
{
   employees= new Employee[]{new Employee("James",5000),new Employee("Jessie",5001)};
   managers= new Employee[]{new Manager("Sapo",10000)};
}

 public static void main(String[] args){
        Company company= new Company();
        managers[0].setBonus(50);
        System.out.println(managers[0].getBonus());    
    }