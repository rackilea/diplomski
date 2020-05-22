import java.util.Arrays;

public class BubbleSort {

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
     String[][] terms = { { "java", "php", "ruby", "csharp", "dotnet", "perl" },
                { "google", "apple", "oracle", "microsoft", "sun" },
                { "http", "web", "dns", "net", "protocol", "packet", "ip" },
                { "london", "madrid", "berlin", "ankara", "astana" } };
     // The cycle time will put the biggest that number in the I That is the highest one .
     //That is why the algorithm called Bubble Sort, because every time like bubbles rise.
     for(int i =terms.length-1;i>=0;--i)
     {
         //The cycle time will traverse 0--(i-1),And when comparing the size of the adjacent two.
         //they will be big like bubbles rise up, and is actually exchange two object
         for(int j=0;j<=i-1;j++)
         {
             if (terms[j].length>terms[j+1].length) {
                 String[] term= terms[j];
                 terms[j] = terms[j+1];
                 terms[j+1]= term;
            }

         }
     }
     for (String[] term : terms) {
            System.out.println(Arrays.toString(term) + ", length: " + term.length);
        }

}

}