Iterator<MyClass> it = taskList.iterator();
while (it.hasNext()) {
    System.out.println(it.next().getClass().getDeclaredFields().toString());
    System.out.println(it.next().getId());
    System.out.println(it.next().getName());
}