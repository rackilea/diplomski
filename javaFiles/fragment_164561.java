String s1 = "1:true,2:false,3:true,4:false,5:false,6:false";

Map<Integer, String> map = new HashMap<>();
for (String s : s1.split(",")){
        map.put(Integer.parseInt(s.substring(0, s.indexOf(":"))), s.substring(s.indexOf(":")+1));
    }

for (Integer key : map.keySet()) System.out.println(key + " " + map.get(key));