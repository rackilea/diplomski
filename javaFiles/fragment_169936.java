public class Test {
    public static void main(String[] args) {
        Vector<Temp> s = new Vector<Temp>();
        s.add(new Temp("a",1));
        s.add(new Temp("b",2));
        s.add(new Temp("c",3));
        s.add(new Temp("b",4));
        s.add(new Temp("b",6));
        s.add(new Temp("c",5));

        String[] seq = { "b", "a", "c" };

        Collections.sort(s, new CustomComparator(seq));

        for (Temp tmp : s)
            System.out.println(tmp);
    }

    static class CustomComparator implements Comparator<Temp> {
        List<String> sequence;

        CustomComparator(String[] seq) {
            sequence = Arrays.asList(seq);
        }

        public int compare(Temp t1, Temp t2) {
            if (t1.s.equals(t2.s))
                return ((Integer) t1.i).compareTo(t2.i);
            return sequence.indexOf(t1.s) - sequence.indexOf(t2.s);
        }
    }
}