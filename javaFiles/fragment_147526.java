public class TestAverages {

public static void main(String... args) {

    List<Double> averages = sortowacz(1000, 0, 100);
    averages.forEach(System.out::println);
}

public static List<Double> sortowacz(final double length, final double min, final double max) {
    List<Double> list = new ArrayList<>();
    Random rand = new Random();
    for (int i = 0; i < length; i++) {

        list.add(min + (max - min) * rand.nextDouble());
    }

    List<Double> averages = new ArrayList<>();
    while (!list.isEmpty()) {
        List<Double> subList = list.subList(0, (int) (length/10));
        double avg = subList.parallelStream().mapToDouble(d -> d).average().getAsDouble();
        averages.add(avg);
        list.removeAll(subList);
    }
    return averages;
 }
}