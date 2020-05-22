package setproblem;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetProblem {

public static void main(String[] args) {

Set<Set<Integer>> originalSet = new HashSet<Set<Integer>>();
Set<Integer> tempSet = new HashSet<Integer>();

//Populate original set with sets of integers 1-10
for (int i = 1; i <= 10; i++) {
    tempSet.add(i);
    originalSet.add(new HashSet<Integer>(tempSet));
    tempSet.clear();
}

System.out.println("Original Sets: ");
for (Set<Integer> set : originalSet) {
    System.out.println(set.toString());
}

//Generate constraints
List<Pair> pairSet = new LinkedList<Pair>();
pairSet.add(new Pair(1, 2));
pairSet.add(new Pair(9, 10));
pairSet.add(new Pair(2, 9));

System.out.println("Set of Pairs: ");
for (Pair p : pairSet) {
    System.out.println(p.toString());
}

System.out.println("Merge and Remove Process");
//For each pair
for (Pair p : pairSet) {
    System.out.println("Iteration::" + p.toString());

    Set<Integer> firstElementSet = getAllElementsFromOriginalSetContaining((Integer)p.getFirst(), originalSet);
    System.out.println("FES::" + firstElementSet.toString());
    Set<Integer> secondElementSet = getAllElementsFromOriginalSetContaining((Integer)p.getSecond(), originalSet);
    System.out.println("SES::" + secondElementSet.toString());

    removeElements(firstElementSet, originalSet);
    removeElements(secondElementSet, originalSet);

    originalSet.removeAll(firstElementSet);
    originalSet.removeAll(secondElementSet);
    firstElementSet.addAll(secondElementSet);
    originalSet.add(firstElementSet);


    for(Set<Integer> s : originalSet){
        System.out.println(s.toString());
    }
}

}

private static Set<Integer> getAllElementsFromOriginalSetContaining(Integer element, Set<Set<Integer>> originalSet) {

    Set<Integer> tempSet = new HashSet<Integer>();

    for(Set<Integer> s : originalSet){
        if(s.contains(element)){
            tempSet.addAll(s);
        }
    }

    return new HashSet<Integer>(tempSet);
}

private static void removeElements(Set<Integer> elementSet, Set<Set<Integer>> originalSet) {

    Iterator originalSetIterator = originalSet.iterator();

    while(originalSetIterator.hasNext()) {
        Set<Integer> s = (HashSet<Integer>)originalSetIterator.next();

        if(s.equals(elementSet)){
             System.out.println("Found set! " + elementSet.toString());
              System.out.println("Found in originalSet! " + s.toString());
              originalSetIterator.remove();
        }
    }        
}

public static class Pair<F, S> {

private F first; //first member of pair
private S second; //second member of pair

public Pair(F first, S second) {
    this.first = first;
    this.second = second;
}

public void setFirst(F first) {
    this.first = first;
}

public void setSecond(S second) {
    this.second = second;
}

public F getFirst() {
    return first;
}

public S getSecond() {
    return second;
}

@Override
public String toString() {
    return "(" + getFirst() + ", " + getSecond() + ")";
}
}
}