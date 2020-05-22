public static void main(String[] args) {
    String s = "34°6′19″N 74°48′58″E / 34.10528°N 74.81611°E / 34.10528; 74.81611This is very good place for tour";
    String[] arr = s.split("(?<=\\d)(?=[A-Z])");
    System.out.println(arr[0]);
    System.out.println(arr[1]);
}