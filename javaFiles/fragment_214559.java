String[] array  = {"DATA1-1","DATA1-2","DATA1-3","DATA1-4","","DATA2-1","DATA2-2","DATA2-3","DATA2-4","","DATA3-1","DATA3-2","DATA3-3","DATA3-4",""};
List<List<String>> result = new ArrayList<>();
List<String> elements = new ArrayList<>();
for(String s : array){
    if("".equals(s) && !elements.isEmpty()){
        result.add(elements);
        elements = new ArrayList<>();
    }else{
        elements.add(s);
    }
}
//Add the remaining elements
if(!elements.isEmpty()){
    result.add(elements);
}
System.out.println(result);