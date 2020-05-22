public class TestSort {

       int c_maxSort = 10000;
       Integer[] unsortedAndFiltered = new Integer[c_maxSort];
       Integer[] index = new Integer[c_maxSort];

       public TestSort() {

          Integer exclude = 0;
          int newPosition;
          int lengthOfOriginalArray;


          Integer[] originalArray = { 5, 3, 0, 2, 7, 1, 5, 6, 8, 4 };
          lengthOfOriginalArray = originalArray.length;

          System.out.print("Original: ");
          for (int i = 0; i < lengthOfOriginalArray; i++)
             System.out.print(originalArray[i] + " ");
          System.out.println(" - Length: " + lengthOfOriginalArray);

          newPosition = 0;

          for (int i = 0; i < lengthOfOriginalArray; i++) {

             if (!originalArray[i].equals(exclude)) {
                index[newPosition] = newPosition;
                unsortedAndFiltered[newPosition] = originalArray[i];
                newPosition++;
             }
          }

          System.out.println("Tags: ");
          for (int i = 0; i < newPosition; i++)
             System.out.print(index[i] + " ");
          System.out.println("");
          System.out.println("Unsorted numbers: ");
          for (int l_loop = 0; l_loop < newPosition; l_loop++)
             System.out.print(unsortedAndFiltered[l_loop] + " ");
          System.out.println("");

          int deleted = lengthOfOriginalArray - newPosition;
          Arrays.sort(index, 0, newPosition, new IndirectedComparator(unsortedAndFiltered, index));

          System.out.println("Sorted Tags: ");
          for (int i = 0; i < newPosition; i++)
             System.out.print(index[i] + " ");
          System.out.println("");
          System.out.println("Sorted Numbers: ");
          for (int i = 0; i < newPosition; i++)
             System.out.print(unsortedAndFiltered[index[i]] + " ");
          System.out.println("");

       }

       public static void main(String[] args) {
          new TestSort();
       }

    }