List<Runnable> list = new ArrayList<>();
list.add(new Runnable() {
    @Override
    public void run() { 
        System.out.println("1");
    }
});
list.add(new Runnable() {
    @Override
    public void run() { 
        System.out.println("2");
    }
});
list.add(new Runnable() {
    @Override
    public void run() { 
        System.out.println("3");
    }
});   

for (Runnable r : list) {
    r.run();
}