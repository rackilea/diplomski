public void sortLinkedList(final String fieldToCompare){

        Collections.sort(testList, new Comparator<LinkedListNode>() {
            @Override
            public int compare(LinkedListNode arg0, LinkedListNode arg1) {
                // TODO Auto-generated method stub
                Field[] fs = classtoLoad.getDeclaredFields();
                for (Field field : fs){
                    field.setAccessible(true);
                    Object fieldName = field.getName();
                     if(fieldToCompare.equalsIgnoreCase((String) fieldName)){
                         try {
                             String value1 = (String) field.get(arg0.getValue());
                             String value2 = (String) field.get(arg1.getValue());
                             return value1.compareToIgnoreCase(value2);      

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }       
                         return 0;
                     }
                }
                return 0;
            }
        }); 
}