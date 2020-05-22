public static void main(String[] args) {

    String[] list ={"Apple ",  "Mel on", "  Ice -cream ", "Television"};

    for (int i = 0; i < list.length; i++) {
            list[i] = list[i].replaceAll(" ", "");
    }

    for (int i = 0; i < list.length; i++) {
           System.out.println(list[i]);
    }
}