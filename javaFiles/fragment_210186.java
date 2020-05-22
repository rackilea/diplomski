import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Scratch {
    public static class Option{
        String opt1;
        String opt2;
        String opt3;
        String optResult;

        public Option(String opt1, String opt2, String opt3, String optResult) {
            this.opt1 = opt1;
            this.opt2 = opt2;
            this.opt3 = opt3;
            this.optResult = optResult;
        }

        public static String merge(String a, String b){
            StringBuilder value = new StringBuilder();
            Set<Character> result = new HashSet<>();
            for(char c : a.toCharArray()){
                result.add(c);
            }
            for(char c : b.toCharArray()){
                result.add(c);
            }
            for(char c : result){
                value.append(c);
            }
            return value.toString();
        }

        public Option(Option a, Option b) {
            this(merge(a.opt1, b.opt1), merge(a.opt2, b.opt2), merge(a.opt3, b.opt3), merge(a.optResult, b.optResult));
        }

        String getKey(){
            return String.join(":", opt1, opt2, opt3);
        }

        int distance(Option option){
            int diff1 = this.opt1.equals(option.opt1)?0:1;
            int diff2 = this.opt2.equals(option.opt2)?0:1;
            int diff3 = this.opt3.equals(option.opt3)?0:1;
            int diff4 = this.optResult.equals(option.optResult)?0:1;
            return diff1 + diff2 + diff3 + diff4;
        }

        public String toString(){
            return getKey();
        }
    }
    public static void main(String[] args) {
        Option[] data = new Option[]{
                new Option("12", "45", "AB", "12"),
                new Option("12", "45", "AB", "3"),
                new Option("12", "45", "AB", "4"),
                new Option("12", "45", "AC", "1"),
                new Option("12", "45", "AC", "12"),
                new Option("3", "45", "AC", "13"),
                new Option("12", "45", "AD", "12"),
        };

        mergeExact(data);
        mergeClose(data, 1);
    }

    private static void mergeClose(Scratch.Option[] data, int distance){
        Map<Option, Set<Character>> buffer = new HashMap<>();
        for(Option option : data) {
            boolean found = false;
            Option toDelete = null;
            for(Map.Entry<Option, Set<Character>> entry : buffer.entrySet()){
                if(option.distance(entry.getKey()) <= distance){
                    Option merged = new Option(entry.getKey(), option);
                    for(char c : option.optResult.toCharArray()){
                        entry.getValue().add(c);
                    }
                    buffer.put(merged, entry.getValue());
                    toDelete = entry.getKey();
                    found = true;
                    break;
                }
            }
            if(found) {
                buffer.remove(toDelete);
            }else{
                Set<Character> set = new HashSet<>();
                for(char c : option.optResult.toCharArray()){
                    set.add(c);
                }
                buffer.put(option, set);
            }
        }
        System.out.println(String.format("merge with distance of %d:: %s", distance, buffer));

    }

    private static void mergeExact(Scratch.Option[] data) {
        Map<String, Set<Character>> buffer = new HashMap<>();
        for(Option option : data){
            Set<Character> item = buffer.computeIfAbsent(option.getKey(), k -> new HashSet<>());
            for(char c : option.optResult.toCharArray()){
                item.add(c);
            }
        }
        System.out.println("exact merge:: "+buffer);
    }


}