public class Population
{
    private int[][] object;

    public Population(int[][] object) {
        this.object = object;
    }

    public void print() {
        for (int i = 0; i < object.length; i++) {
            for (int j = 0; j < object[i].length; j++)
                System.out.print(object[i][j]);
            System.out.println();
        }
    }
}



public static void main(String[] args) {
    ArrayList<Population> population = new ArrayList<>();

    // 5 Population
    for (int nr = 1; nr <= 5; nr++) {
        // each Population has an int[5][5]
        int[][] object = new int[5][5];
        // int the object
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
            object[i][j] = nr;
        // add the Population with the object just created
        population.add(new Population(object));
    }

    // print out each Population object
    for (int i = 0; i < population.size(); i++) {
        System.out.println("Population " + (i + 1) + ":");
        population.get(i).print();
        System.out.println();
    }
}