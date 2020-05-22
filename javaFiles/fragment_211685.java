import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.List;


    public class Test002 {

        public static void main(String[] args) throws Exception {
            List<String> input = new ArrayList<String>();

            input.add("2013-07-31,A,47");
            input.add("2013-06-28,A,52");
            input.add("2013-05-31,A,63");

            input.add("2013-07-31,B,47");
            input.add("2013-06-28,B,54");
            input.add("2013-05-31,B,91");

            input.add("2013-07-31,C,78");
            input.add("2013-06-28,C,24");

            input.add("2013-07-31,D,99");
            input.add("2013-05-31,D,82");

            HashSet<Date> dates = new HashSet<Date>();
            HashSet<String> products = new HashSet<String>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            HashMap<String, Integer> counts = new HashMap<String, Integer>();

            for (String s : input){
                String[] str = s.split(",");
                dates.add(sdf.parse(str[0]));
                products.add(str[1]);
                counts.put(str[0] + "#" + str[1], Integer.parseInt(str[2]));
            }

            for (String p : products){
                for (Date dt : dates){
                    Integer cnt = counts.get(sdf.format(dt) + "#" + p);
                    if (cnt == null){
                        System.out.print("00 ");
                    }else{
                        System.out.printf("%2d ", cnt);
                    }
                }
                System.out.println();
            }
        }

    }