import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HasseDiagramTest2
{
    public static void main(String[] args)
    {
        int numberOfElements = 2;
        int numberOfSetsPerNode = 2;

        List<Integer> list = createList(numberOfElements);

        List<List<Set<Integer>>> prunedNodes = 
            new ArrayList<List<Set<Integer>>>();
        List<Set<Integer>> prunedNode = new ArrayList<Set<Integer>>();
        prunedNode.add(Collections.singleton(1));
        prunedNode.add(Collections.singleton(1));
        prunedNodes.add(prunedNode);

        compute(list, numberOfSetsPerNode, prunedNodes);
    }

    private static List<Integer> createList(int numberOfElements)
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<numberOfElements; i++)
        {
            list.add(i+1);
        }
        return list;
    }

    private static <T> void compute(
        List<T> elements, int numberOfSetsPerNode,
        List<List<Set<T>>> prunedNodes)
    {
        Set<List<Set<T>>> level0 = createLevel0(numberOfSetsPerNode);
        System.out.println("Level 0:");
        print(level0);

        Set<List<Set<T>>> currentLevel = level0;
        int level = 0;
        while (true)
        {
            Set<List<Set<T>>> nextLevel = 
                createNextLevel(currentLevel, elements, prunedNodes);
            if (nextLevel.size() == 0)
            {
                break;
            }

            System.out.println("Next level: "+nextLevel.size()+" nodes");
            print(nextLevel);

            currentLevel = nextLevel;
            level++;
        }
    }

    private static <T> Set<List<Set<T>>> createLevel0(int numberOfSetsPerNode)
    {
        Set<List<Set<T>>> level0 = 
            new LinkedHashSet<List<Set<T>>>();
        List<Set<T>> level0element = new ArrayList<Set<T>>();
        for (int i=0; i<numberOfSetsPerNode; i++)
        {
            level0element.add(new LinkedHashSet<T>());
        }
        level0.add(level0element);
        return level0;
    }

    private static <T> Set<List<Set<T>>> createNextLevel(
        Set<List<Set<T>>> currentLevel, List<T> elements,
        List<List<Set<T>>> prunedNodes)
    {
        Set<List<Set<T>>> nextLevel = new LinkedHashSet<List<Set<T>>>();
        for (List<Set<T>> currentLevelElement : currentLevel)
        {
            for (int i=0; i<currentLevelElement.size(); i++)
            {
                for (T element : elements)
                {
                    List<Set<T>> nextLevelElement = copy(currentLevelElement);
                    Set<T> next = nextLevelElement.get(i);
                    boolean changed = next.add(element);
                    if (!changed)
                    {
                        continue;
                    }
                    boolean pruned = false;
                    for (List<Set<T>> prunedNode : prunedNodes)
                    {
                        if (isSuccessor(prunedNode, nextLevelElement))
                        {
                            pruned = true;
                        }
                    }
                    if (!pruned)
                    {
                        nextLevel.add(nextLevelElement);
                    }
                    else
                    {
//                        System.out.println(
//                            "Pruned "+nextLevelElement+
//                            " due to "+prunedNodes);
                    }
                }
            }
        }
        return nextLevel;
    }

    private static <T> boolean isSuccessor(
        List<Set<T>> list, List<Set<T>> successor)
    {
        for (int i=0; i<list.size(); i++)
        {
            Set<T> set = list.get(i);
            Set<T> successorSet = successor.get(i);
            if (!successorSet.containsAll(set))
            {
                return false;
            }
        }
        return true;
    }

    private static <T> List<Set<T>> copy(List<Set<T>> list)
    {
        List<Set<T>> result = new ArrayList<Set<T>>();
        for (Set<T> element : list)
        {
            result.add(new LinkedHashSet<T>(element));
        }
        return result;
    }

    private static <T> void print(
        Iterable<? extends Collection<? extends Collection<T>>> sequence)
    {
        for (Collection<? extends Collection<T>> collections : sequence)
        {
            System.out.println("    "+collections);
        }
    }


}