import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private ArrayList<String> wordList = new ArrayList<String>();

    public Test() {
        wordList.add("Test");
        wordList.add("Bee");
        wordList.add("Pig");
        wordList.add("Dog");
        alphaSort();
    }

    public void alphaSort() {
        String[] alphaList = new String[wordList.size()];
        int count = 0;
        while(count < wordList.size()) {
            alphaList[count] = wordList.get(count);
            count++;
        }
        int shortestStringIndex;
        for(int j = 0; j < alphaList.length - 1; j++) {
            shortestStringIndex = j;
            for(int i = j + 1; i < alphaList.length; i++) {
                if(alphaList[i].trim().compareTo(alphaList[shortestStringIndex].trim()) < 0) {
                    shortestStringIndex = i;
                }
            }
            if(shortestStringIndex != j) {
                String temp = alphaList[j];
                alphaList[j] = alphaList[shortestStringIndex];
                alphaList[shortestStringIndex]= temp;
            }
        }
        count = 0;
        while(count < alphaList.length) {
            System.out.println(alphaList[count++]);
        }
    }

}