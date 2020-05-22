import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Map<String, Person> personMap = new HashMap<>();
        Set<Person> parents = new HashSet<>();
        Set<Person> children = new HashSet<>();

        //Build tree
        try(BufferedReader reader = new BufferedReader(new FileReader("file.csv"))){
            String line = reader.readLine();
            while(line != null){
                String[] parentChild = line.split("\\|");
                Person parent, child;
                //find or create parent
                if(personMap.containsKey(parentChild[0]))
                    parent = personMap.get(parentChild[0]);
                else{
                    parent = new Person(parentChild[0]);
                    personMap.put(parentChild[0], parent);
                }

                //find or create child
                if(personMap.containsKey(parentChild[1]))
                    child = personMap.get(parentChild[1]);
                else{
                    child = new Person(parentChild[1]);
                    personMap.put(parentChild[1], child);
                }

                //add parent to child
                child.addParent(parent);

                parents.add(parent);
                children.add(child);

                line = reader.readLine();
            }


        }

        Set<Person> pureChildren = new HashSet<>(children);
        pureChildren.removeAll(parents);

        //Find longest path
        List<Person> longest = new ArrayList<>();
        for(Person person:pureChildren){
            List<Person> path = person.getLongestPath();
            if(path.size() > longest.size()){
                longest = path;
            }
        }

        //print path
        for(Person p:longest){
            System.out.println(p.getName());
        }

    }

}