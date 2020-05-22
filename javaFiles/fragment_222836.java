public static void main (String[] args) {
    ArrayList<Hashtable> objArrlistHshTbl = new ArrayList<Hashtable>();
    for(int i= 1; i< 3; i++){
              if(i == 1){
              Hashtable objHashTable = new Hashtable();
    objHashTable.put("Key" + i, "Value1");
    objHashTable.put("Key" + i+1, "Value2");
              objArrlistHshTbl.add(objHashTable);
              }else{
                  Hashtable objHashTable = new Hashtable();
                  objHashTable.put("Key" + i, "Value3");
        objHashTable.put("Key" + i+1, "Value4");
                  objArrlistHshTbl.add(objHashTable);
              }

    }


    }
}