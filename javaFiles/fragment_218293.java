import com.google.common.collect.*;
...

// data contains the words from the text file
Multiset<String> myMultiset = ImmutableMultiset.copyOf(data);

for (String word : Multisets.copyHighestCountFirst(myMultiset).elementSet()) {
    System.out.println(word + ": " + myMultiset.count(word));
}