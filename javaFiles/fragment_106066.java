public static void main(String[] args) {         
     List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21));
     List<Integer> odds = new ArrayList<>();
     List<Integer> evens = new ArrayList<>();
     numbers.stream().forEach(x -> (x % 2 == 0 ? evens : odds).add(x));
 }