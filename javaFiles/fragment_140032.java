public class Contest {

    public static void main(String []args) {
        Map<String,Integer> timings = new HashMap<String,Integer>();
        timings.put("Swimming", 1);
        timings.put("Running", 1);
        timings.put("Cycling", 1);
        Contestant a = new Contestant("A",timings);

        timings = new HashMap<String,Integer>();
        timings.put("Swimming", 1);
        timings.put("Running", 2);
        timings.put("Cycling", 1);
        Contestant b = new Contestant("B",timings);

        timings = new HashMap<String,Integer>();
        timings.put("Swimming", 1);
        timings.put("Running", 2);
        timings.put("Cycling", 2);
        Contestant c = new Contestant("C",timings);

        List<Contestant> contestants = new ArrayList<Contestant>();
        contestants.add(a);
        contestants.add(b);
        contestants.add(c);
        Collections.sort(contestants,new ContestantComparator());

        for(Contestant contestant : contestants) {
            System.out.println(contestant.getName());
        }

    }

}