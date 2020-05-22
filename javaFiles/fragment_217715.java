package org.junit.runner.manipulation;

public class Sorter implements Comparator<Description> {
    /**
     * NULL is a <code>Sorter</code> that leaves elements in an undefined order
     */
    public static Sorter NULL= new Sorter(new Comparator<Description>() {
        public int compare(Description o1, Description o2) {
            return 0;
        }});