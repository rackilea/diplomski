public static Exam[] collateExams(Exam[] exams)
{
     Exam[] r = new Exam[exams.length]; 
     int index = 0;

     for (int i = 0; i < exams.length ; i++)
     {
         if (exams[i].getExamType() == 'm')
         {
             r[index*2] = new Exam(exams[i].getFirstName(), exams[i].getLastName(), exams[i].getID(), 'm', exams[i].getScore());
             for(int j = 0; j < exams.length; j++)
             {
                 if((exams[j].getExamType() == 'f') && (exams[i].getID() == exams[j].getID()))
                 {
                     r[index*2 + 1] = new Exam(exams[j].getFirstName(), exams[j].getLastName(), exams[j].getID(), 'f', exams[j].getScore());
                 }
             }
             index++;
         }
     }
     return r;    
 }