final HashSet<Runnable> set = new HashSet<>();
//store the runnable in variable so that we know which runnable to remove afterwards
final Runnable milk = new Runnable() {
    public void run() {
        milk(); //will execute milk()
    }
};
//add the runnable as usual
set.add(milk);
//add some other runnables
set.add(new Runnable() {
    public void run() {
        doSomething(); //will execute doSomething()
    }
});
// and so on

for(Runnable r : set) {
    r.run(); //will execute each Runnable in the set
}
set.remove(milk); //remove the Runnable we created first