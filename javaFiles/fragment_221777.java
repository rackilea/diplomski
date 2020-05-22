package aaa;

import java.util.ArrayList;
import java.util.List;

// An OBSERVABLE class
public class Person {
    // STEP 1: keep track of "who cares"
    //         outsiders with interest implement the observer interface
    //         and register with the person to indicate that they care
    private List<SomethingChangedListener> listeners = new ArrayList<SomethingChangedListener>();
    public void addSomethingChangedListener(SomethingChangedListener scl) {
        listeners.add(scl);
    }
    public void removeSomethingChangedListener(SomethingChangedListener scl) {
        listeners.remove(scl);
    }

    // STEP 2: be able to notify those observers by calling a method in the observer interface
    protected void fireSomethingChanged(String name, Object newValue) {
        for (SomethingChangedListener scl : listeners) {
            scl.somethingChanged(name, newValue);
        }
    }

    // STEP 3: whenever the data changes, notify the observers
    private String name;
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        fireSomethingChanged("age", name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        fireSomethingChanged("name", name);
    }
}