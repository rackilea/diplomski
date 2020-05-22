Map<String,Integer> map=new HashMap<>();
 map.put("A",1);
 map.put("B",2);
 map.put("C",3);

 JTable table=new JTable(map.size(),2);
 int row=0;
 for(Map.Entry<String,Integer> entry: map.entrySet()){
      table.setValueAt(entry.getKey(),row,0);
      table.setValueAt(entry.getValue(),row,1);
      row++;
 }