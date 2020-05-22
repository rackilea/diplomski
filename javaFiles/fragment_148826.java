package fr.imag.ufrima.tat.tp6.aspects.monitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Rodmar CONDE
 * 
 * Monitor used to prevent adding elements to a collection that has already been added to a HashMap
 *
 */
public class MonitorHashCode {
    /**
     *  Stores the system identity hashcode of the collections that are added to the monitored HashCode 
     */
    private List<Integer> collectionsAddedToHashSet;

    public MonitorHashCode() {
        System.out.println("Monitor created.");
        collectionsAddedToHashSet = new ArrayList<Integer>();
    }

    /**
     * Adds the system identity hashcode of the passed collection to the list
     * 
     * @param c Collection to be added to the list
     */
    public void addElementsToHashCode(Collection c) { 
        System.out.println("\naddElementsToHashCode.");

        collectionsAddedToHashSet.add(System.identityHashCode(c));
        System.out.println("\nCollection has been added to HashMap.");
    }

    /**
     * 
     * Before adding the element, search if the collection exists already
     * in the list, if so print an error.
     *
     * @param pointCutTarget
     */
    public void addElementsToCollection(Object pointCutTarget) { 
        System.out.println("\naddElementsToCollection.");

        int systemIdentityHashCode = System.identityHashCode(pointCutTarget);
        boolean isContained = collectionsAddedToHashSet.contains(systemIdentityHashCode);
        System.out.println(String.format("currentCollection: %s systemIdentityHashCode: %d - isContained: %s", pointCutTarget, systemIdentityHashCode, isContained));
        if (isContained) {
            System.out.println("Error: you have already added this collection into a hashmap, you can not add more elements into it!");
        }
    }

}