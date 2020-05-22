import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class IssueFeed {
    private String symptom;
    private String problem;
    private String solution;

    public IssueFeed(String symptom, String problem, String solution) {
        this.symptom = symptom;
        this.problem = problem;
        this.solution = solution;
    }
    public String getSymptom() {
        return symptom;
    }
    public String getProblem() {
        return problem;
    }
    public String getSolution() {
        return solution;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((symptom == null) ? 0 : symptom.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IssueFeed other = (IssueFeed) obj;
        if (symptom == null) {
            if (other.symptom != null)
                return false;
        } else if (!symptom.equals(other.symptom))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "IssueFeed [symptom=" + symptom + ", problem=" + problem
                + ", solution=" + solution + "]";
    }
}

public class Sample {

    public static void main(String[] args) {
        List<IssueFeed> mainList = new ArrayList<IssueFeed>(
                Arrays.asList(new IssueFeed[] {
                        new IssueFeed("sym1", "p1", "s1"),
                        new IssueFeed("sym2", "p2", "s2"),
                        new IssueFeed("sym3", "p3", "s3"),
                        new IssueFeed("sym1", "p1", "s1") }));
        System.out.println("Initial List : " + mainList);
        Set<IssueFeed> list_of_non_dupes = new LinkedHashSet<IssueFeed>();
        List<IssueFeed> duplicateDatalist = new ArrayList<IssueFeed>(); 
        for(IssueFeed feed : mainList){
            if(!list_of_non_dupes.add(feed)) {
                duplicateDatalist.add(feed);
            }
        }
        mainList = new ArrayList<IssueFeed>(list_of_non_dupes); // Remove the duplicate items from the main list, leaving at least 1 item with that symptom to be display
        list_of_non_dupes.removeAll(duplicateDatalist); // list of only objects with unique symptom
        System.out.println("Fina main list : " + mainList);
        System.out.println("Unique symptom" + list_of_non_dupes);
        System.out.println("Duplicate symptom" + duplicateDatalist);
    }
}