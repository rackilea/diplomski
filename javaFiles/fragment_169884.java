public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    Random rand = new Random();

    while (list.size() < 25) {
      int index = rand.nextInt(101);

      if (!list.contains(index)) {
          list.add(index);
      }
    }
    System.out.println(list);
  }
}