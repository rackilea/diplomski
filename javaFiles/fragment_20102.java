private void insertCoursesToSet(Set<Course> set, int n, int it) {
    Scanner s = new Scanner(System.in);

    if(it==1) 
        for(int i=0 ; i<n ; i++){
            System.out.println("Please enter name:");
            s.nextLine(); //clear buffer
            String name = s.nextLine();
            System.out.println("Please enter avg:");
            float avg = s.nextFloat();
            set.add(new Course<String>(name,avg));
        }
    else
        for(int i=0 ; i<n ; i++){
            System.out.println("Please enter id:");
            Integer id = s.nextInt();
            System.out.println("Please enter avg:");
            float avg = s.nextFloat();
            set.add(new Course<Integer>(id,avg));
        }
}

public  class Course<E>{
    private E idOrName;
    private float avg;

    public Course(E idOrName, float avg){
        this.idOrName = idOrName;
        this.avg = avg;
    }
}