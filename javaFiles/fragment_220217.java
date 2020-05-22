Scanner input = new Scanner(System.in);
    LinkedList<Integer> list = new LinkedList<Integer>();

     System.out.println("Please enter the name of the course:");
     String course=input.next();

     System.out.println("Please enter the scores for CSC 201 on a single line and type a -1 at the end");
     int max=0;
     int min=Integer.MAX_VALUE;

     int sum=0;
     int grade;
    that: while(true){
        grade=input.nextInt();

        if(grade==-1)
             break that;

         list.add(grade);
         sum=sum+grade;

         if(grade>max)
             max=grade;
         if(grade<min)
             min=grade;
     }
     System.out.println("The course name: "+ course);
     System.out.println("Number of Scores :"+list.size());
     System.out.println("The Average Score :"+(double)sum/list.size());
     System.out.println("The Minimum Score: "+min);
     System.out.println("The Maximum Score :"+max);