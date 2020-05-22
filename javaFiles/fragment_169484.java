public class MainClass {
    public static void main(String[] args) {
        System.out.println(new Date()+": Let's start our StackOverflow helper project!");

                List<String>  res= Arrays.asList("tester1","tester2","solverC1","solverC2","solverS2","solverS1","tester1","tester4","system");


                Map<String,Long> reuslts=res.stream().collect( Collectors.groupingBy(s-> s.replaceAll("\\d","").toString(),  Collectors.counting()));

                 StringBuilder sb = new StringBuilder();
                Iterator<Entry<String, Long>> iter = reuslts.entrySet().iterator();
                while (iter.hasNext()) {
                    Entry<String, Long> entry = iter.next();
                    sb.append(entry.getKey());
                    sb.append('=').append('"');
                    sb.append(entry.getValue());
                    sb.append('"');
                    if (iter.hasNext()) {
                        sb.append(',').append(' ');
                    }
                }
                System.out.println(sb.toString());

    }   

}

// It should print system="1", tester="4", solverS="2", solverC="2"