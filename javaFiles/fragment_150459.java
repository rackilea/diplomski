Map<Integer,String> mapGroupThree = new HashMap<Integer,String>();
 String result = "";

 if(frequency <= 31) {
   // Group 1
   result = mapGroupOne.get(frequency);
 } else if (frequency <= 62) {
   // Group 2
   result = mapGroupTwo.get(frequency);
 } else if (frequency <= 124) {
   // Group 3
   result = mapGroupThree.get(frequency);
 } etc etc

 textView1.setText(result==null?"Out of Range":result);