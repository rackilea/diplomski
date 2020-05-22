public class Main {
    public static void main(String[] args){
        int [][]myArray= {
                {2,3,6,7},
                {4,5,6,7},
                {2,2,2,2},
        };      
        double total=0;
        int assignment=1;

        System.out.println("Average score of each assignment:");
        for(int i=0;i<myArray[0].length;i++) {
            for(int j=0;j<myArray.length;j++) {
                total+=myArray[j][i];          
            }
            System.out.println("Assignment #" + assignment++ + " Average: " + (total/3));
            total=0;
        }
    }
}