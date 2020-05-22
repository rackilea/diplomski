public static void main(String[] args) {
    List<Double> list = Arrays.asList(6527.6, 6755.6, 7009.9, 7384.7, 7775.9, 8170.7);

    for (int i = 1; i < list.size(); i++) {
        double avg = (list.get(i) + list.get(i - 1)) / 2;
        System.out.println("avg(" + (i - 1) + "," + i + ") = " + avg);
    }
}