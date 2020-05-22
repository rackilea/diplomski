import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {

    private final String name;
    private Set<Person> parents = new HashSet<>();

    private List<Person> longestPath = null;

    /**
     * Initialize a new person
     */
    public Person(String name){
        this.name = name;
    }

    /**
     * Return the name of this person
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Return a copy of the parent set
     */
    public Set<Person> getParents(){
        Set<Person> copy = new HashSet<>();
        copy.addAll(parents);
        return copy;
    }

    /**
     * Add a parent to this child.
     */
    public void addParent(Person parent){
        parents.add(parent);
    }

    /**
     * Return the longest child-parent path, starting from and including this person
     */
    public List<Person> getLongestPath(){
        if(longestPath == null){

            longestPath = new ArrayList<>();
            longestPath.add(this);
            for(Person parent:parents){
                List<Person> path = parent.getLongestPath();
                if(path.size() >= longestPath.size()){
                    path.add(0,this);
                    longestPath = path;
                }
            }
        }

        return new ArrayList<>(longestPath);
    }

}