ArrayList<String> in =new ArrayList<String>();
ArrayList<List<String>> out = new ArrayList<List<String>>();
for (HSSFRow n:filteredRows){
    for (Cell cell : n) {
       // Logic here
    }
    out.add(in);
    in.clear();
}