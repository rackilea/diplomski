import java.io.BufferedReader;
import java.io.InputStreamReader;

class del {    
   public static void main(String args[]) throws java.io.IOException {

int read;char  grade;
 read = 75;   

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter a score between 0 and 100: ");
read = Integer.parseInt(br.readLine());

if (100 >= read && read >85) grade = 'A'; 
else if (85 >= read && read >75) grade = 'B'; 
else if (75 >= read && read >60) grade = 'C';
else if (60 >= read && read >50) grade = 'D'; // you may want to change 50
else grade = 'F';
        System.out.println("GRADE " + grade);   
    }
}