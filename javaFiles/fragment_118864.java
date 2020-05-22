for (String key: keywordMap.keySet()) {
    List<Integer> values = keywordMap.get(key);
    writer.print(key + "=\n\r[");
    for(int i = 0; i < values.length(); i++){
         writer.print(values.get(i));
         if(i % 3 == 0){
            writer.print("\n\r");
         }
    }
    writer.print("]\n\r");
}