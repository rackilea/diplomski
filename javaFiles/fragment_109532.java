List<Set<String>> bridges = new ArrayList<Set<String>>();

Set<String> tempBridge = new HashSet<String>();

for(int j=0;j<5;j++){    
    tempBridge = getBridges();
    bridges.add(tempBridge);
    System.out.println(bridges.size());
}    


Set<String> getBridges(){
    Set<String> temp = new HashSet<String>();
    for(int k=0;k<8;k++){
        // Add some data to temp
        temp.add("test" + Integer.toString(k));
    }
    return temp;
}