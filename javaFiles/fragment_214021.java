public static void main( String [] args )
{  
  int[] grades = new int[100];

  for (int i=0; i<grades.length; i++)
  {
     grades[i] = (int) Math.floor(Math.random()*101);
  }

  classRoom1 = new GradeBook(grades);
  System.out.println( "The class size is " + classRoom1.getStudent() + " students." + "\n" + classRoom1.toString() ); 

  classRoom2 = new GradeBook(grades);
  System.out.println( "The class size is " + classRoom2.getStudent() + " students." + "\n" + classRoom2.toString() );

  if ( classRoom1.equals( classRoom2 ))
  System.out.println("Classroom 1 has the same grades and class size as Classroom 2.");
  else
  System.out.println("Classroom 1 and Classroom 2 have different grades and class sizes.");
}