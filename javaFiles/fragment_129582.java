private static void heap(int[] maxElements) {
    int candidate = 1;
    if (maxElements[1] > maxElements[2]) {
        candidate = 2;
    }
    if (maxElements[0] > maxElements[candidate]) {
        int temp = maxElements[0];
        maxElements[0] = maxElements[candidate];
        maxElements[candidate] = temp;
    }
}

private static int addElement(int k, int[] maxElements, int item) {
    if (k < 3) {
        maxElements[k++] = item;
        if (k < 3) {
            System.out.println("-1");
        } else {
            heap(maxElements);
            System.out.println(maxElements[0] * maxElements[1] * maxElements[2]);
        }
    } else {
        if (maxElements[0] < item) {
            maxElements[0] = item;
            heap(maxElements);
        }
        System.out.println(maxElements[0] * maxElements[1] * maxElements[2]);
    }
    return k;
}

public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // no. of elements
    String line = br.readLine(); //accepting those elements in a string
    int[] maxElements = new int[3];
    int k = 0;
    int item = 0;
    char c;
    for (int i = 0; i < line.length(); i++) {
        c = line.charAt(i);
        if (c == ' ') {
            k = addElement(k, maxElements, item);
            item = 0;
        } else {
            item = item * 10 + (c - '0');
        }
    }
    addElement(k, maxElements, item);
}