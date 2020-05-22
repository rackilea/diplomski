int minSize = Math.min(testList.get(j).getDate().size(), testList.get(j).getTotalReturnIndex().size());

List<String[]> data = new ArrayList<String[]>();
for(int m = 0; m < minSize; m++) {
    //TODO remove .replace('.', ',')
    data.add(new String[] {testList.get(j).getCompanyName(),
        testList.get(j).getDate().get(m), 
        testList.get(j).getCurrency(), 
        testList.get(j).getTotalReturnIndex().get(m).toString().replace('.', ','),
        testList.get(j).getPrice().get(m).toString().replace('.', ','),
        "", 
        (m < sublist.size())? sublist.get(m) : "" 
    });
}