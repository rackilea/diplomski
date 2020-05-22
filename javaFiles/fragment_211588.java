public static List<String> merge() throws Exception{

List<String> newStringList = new ArrayList<>();

        for(int i = 0; i <convertedList.size(); i++){
            String split [] = convertedList.get(i).split(" ");
            split[0] = SeperatedMetricList.get(i).toString();
            String joinedString = String.join(" ", split);
            newStringList.add(joinedString);
        }
       return newStringList;
    }