public class Main {

    public static void main(String[] args) {

        final SimpleDateFormat df = new SimpleDateFormat("MMMyyyy");

        Map<String, Integer> map = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                try {
                    return df.parse(s1).compareTo(df.parse(s2));
                } catch (ParseException e) {
                    throw new RuntimeException("Bad date format");
                }
            };
        });

        map.put("Dec2011",1);
        map.put("Jan2011",0);
        map.put("Feb2011",1);
        map.put("Mar2011",0);
        map.put("Oct2011",1);
        map.put("Sep2011",0);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}