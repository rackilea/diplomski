interface Stuff {
    void doStuff();
}

public class SubclassA extends BaseClass implements Stuff {
    // Does it need BaseClass still?
    public doStuff() {
        ...
    } 
}

public class SubclassB extends BaseClass implements Stuff {
    // Does it need BaseClass still?
    public doStuff() {
        ...
    } 
}

// Example client code...
public class MyStuffClient {

    Stuff s = new SubclassA();
    ...
    public void onStuff() {
        s.doStuff();
    } 
}