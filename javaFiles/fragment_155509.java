List<Runnable> list = new ArrayList<>();
list.add(() -> System.out.println("1"));
list.add(() -> System.out.println("2"));
list.add(() -> System.out.println("3"));

for (Runnable r : list) {
    r.run();
}