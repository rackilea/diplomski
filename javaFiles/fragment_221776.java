package aaa;

// AN OBSERVER INTERFACE
// This is a contract between an interested party (the OBSERVER) and
//   the thing it would like to know has changed (the OBSERVABLE)
// The OBSERVABLE will call this method whenever its data changes
public interface SomethingChangedListener {
    void somethingChanged(String name, Object newValue);
}