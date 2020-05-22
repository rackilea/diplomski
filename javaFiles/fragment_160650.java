final HashSet<Runnable> set = new HashSet<>();
set.add(new Runnable() {
    public void run() {
        milk(); //will execute milk()
    }
});
set.add(new Runnable() {
    public void run() {
        doSomething(); //will execute doSomething()
    }
});
// and so on

for(Runnable r : set) {
    r.run(); //will execute each Runnable in the set
}