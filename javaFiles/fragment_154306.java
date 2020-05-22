public static void main(String[] args) {
    File file = new File("C:\\Users\\coderva.org\\Documents\\numbers.txt");

    Scanner sc = null;

    try {
        sc = new Scanner(file);
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
        e.printStackTrace();
        return;
    }

    ArrayList<Float> list = new ArrayList<Float>();

    while (sc.hasNextFloat())
        list.add(sc.nextFloat());

    int size = list.size();

    if (size == 0) {
        System.out.println("Empty list");
        return;
    }

    Collections.sort(list);

    for (int i = 0; i < size; i++) {
        System.out.print(list.get(i) + " ");
    }

    System.out.println();

    // mean value, classical way
    float sum = 0;
    for (float x : list) {
        sum += x;
    }

    float mean = sum / size; // mean as integer

    //median
    float median;

    if (size % 2 == 0) {
        float x1 = list.get(size / 2 - 1);
        float x2 = list.get(size / 2);
        median = (x1 + x2) / 2;
    } else {
        median = list.get(size / 2);
    }

    //mode
    Float mode = null;
    int counter = 1;
    for (int i = 0; i < size; i++) {
        int freq = Collections.frequency(list, list.get(i));
        if (freq > counter) {
            mode = list.get(i);
            counter = freq;
        }
    }

    System.out.println("Mean=" + mean);

    System.out.println("Median=" + median);

    if (mode == null) {
        System.out.println("No mode found");
    } else {
        System.out.println("Mode=" + mode);
    }
}