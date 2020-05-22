class HistogramChart {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      System.out.println("Please enter data separated by spaces: ");
      String data = scan.nextLine();

      String tmpDataArray[] = data.split(" ");

      int dataArray[] = new int[tmpDataArray.length];
      for (int i = 0; i < dataArray.length; ++i) {
          dataArray[i] = Integer.parseInt(tmpDataArray[i]);
      }
}