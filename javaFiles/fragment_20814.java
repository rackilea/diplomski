String[] str={"12345$abcd","12332$abcgd","5555$afdsd"};

Map<String, String> map = new HashMap<String, String>();
for(final String s : str) {
   final String split[] = s.split("\\$");
   map.put(split[0], split[1]);
}