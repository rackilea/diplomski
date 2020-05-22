static Integer[][] myDouble = new Integer[10][12];

for (int i = 0; i < myDouble.length; ++i) {
     IntSummaryStatistics statistics = Arrays.asList(myDouble[i]).stream().filter(intValue -> intValue!=null).collect(Collectors.summarizingInt(Integer::intValue));
     System.out.println("Average: "+statistics.getAverage()+", min: "+statistics.getMin()+", max: "+statistics.getMax());
}