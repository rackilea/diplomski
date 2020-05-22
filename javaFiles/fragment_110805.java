do
    {
    System.out.printf("\nEnter a grade (%d to finish): ", STOP);
    grade = input.nextFloat();
        if(grade != STOP)
          {
            sumGrades = sumGrades + grade;
            studentCount++;
          }

      } while(grade != STOP);