public static class ABC {
    private int id;
    private String name;
    private int[] numbers;

    public ABC() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}

public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    ABC abc = new ABC();
    abc.setId(1);
    abc.setName("Hello");
    int[] newnumbers = new int[5];
    for(int i = 0; i < newnumbers.length; i++) {
        newnumbers[i] = i;
    }
    abc.setNumbers(newnumbers);
    ABC abc2 = new ABC();
    abc2.setName("World");

    ABC abcFinal = mergeObjects(abc, abc2);
    System.out.println("Properties of ABC Final:");
    System.out.println("ID: " + abcFinal.getId());
    System.out.println("Name: " + abcFinal.getName());
    System.out.println("Numbers: " + Arrays.toString(abcFinal.getNumbers()));
}