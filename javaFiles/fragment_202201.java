This example gives how to shuffle elements in the ArrayList. By calling Collections.shuffle() method you can shuffle the content of the ArrayList. Every time you call shuffle() method, it generates different order of output. 

        **Example #1**

            public class MyListShuffle {

                public static void main(String a[]){
                    ArrayList<String> wordList = new ArrayList<String>();
                    list.add("Stack");
                    list.add("Overflow");
                    list.add("is");
                    list.add("a");
                    list.add("place");
                    list.add("great");
                    list.add("to";
                    list.add("learn");
                    list.add("and");
                    list.add("teach");



                    Collections.shuffle(wordList);
                    System.out.println("Results after shuffle operation #1:");
                    for(String word: wordList){
                        System.out.println(word);
                    }


                    Collections.shuffle(wordList);
                    System.out.println("Results after shuffle operation #2:");
                    for(String word: wordList){
                        System.out.println(word);
                    }
                }
            }

        Note that The shuffle(List<?>) method is used to randomly permute the specified list using a default source of randomness.

    The original declaration:
    -  java.util.Collections.shuffle() method.  
         - public static void shuffle(List<?> list)
            - Parameter: "list" is the list to be shuffled.

Output:
Results after shuffle operation #1:
to 
learn
and
Stack
Overflow
a
teach 
is
great
place
Results after shuffle operation #2:
Overflow
place
great 
and
teach
to
is
learn
Stack
a