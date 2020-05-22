public class YourClass implements Comparator<String>{

     public int compare(Object o1, Object o2) {

        String student1Name = ((String) o1); 
        String student2Name = ((String) o1); 

        int student1Vowels = countVowels(student1Name);
        int student2Vowels = countVowels(student2Name);

        if (student1Name == student2Name)
             return 0;
        if (student1Name > student2Name)
             return -1;
        if (student1Name < student2Name)
             return 1; 
    }   

    private int countVowels(String name){
       //return the vowels count
    }

}