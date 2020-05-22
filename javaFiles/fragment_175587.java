public static void main(String[] args) {
    for(int size = getSize(), i=0; i<size; i++) {
        System.out.println("i: " + i);
    }
}


private static int getSize() {
    int size = new Random().nextInt(10);
    System.out.println("size: " + size);
    return size;
}

size: 5
i: 0
i: 1
i: 2
i: 3
i: 4