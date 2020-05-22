int[] arrayObject={1,5,7,4,5,1,8,4,1};
List<Integer> uniqueList=new LinkedList<>();
List<Integer> duplicateList=new LinkedList<>();
for(int i=0; i<arrayObject.length; i++){
    if(!uniqueList.contains(arrayObject[i])){
        uniqueList.add(arrayObject[i]);
    }else if(!duplicateList.contains(arrayObject[i])){
        duplicateList.add(arrayObject[i]);
    }
}
System.out.println("Elements without duplicates: "+uniqueList);
System.out.println("Duplicated elements: "+duplicateList);