/**
 * Local cache of added items. 
 * Key - Description Text (ID of item), Value - Text
 */
private final Map<String, TextView> mActiveViews = new HashMap<>();

private method1() {
...............
while (condition) {
    final TextView dec1= (TextView) addView.findViewById(R.id.dec1);
    final   TextView dec2= (TextView) addView.findViewById(R.id.dec2);
    final TextView dec3= (TextView) addView.findViewById(R.id.dec3);

     dec_v1.setContentDescription("a"+dbid);
     mActiveViews.put("a"+dbid, dec1)
     dec_v2.setContentDescription("b"+dbid);
     mActiveViews.put("b"+dbid, dec2)
     dec_v3.setContentDescription("c"+dbid);
     mActiveViews.put("c"+dbid, dec3)
   }
 .................
}


 public void getD() {
    /* Access to all Active TextViews
     */
    for (Map.Entry<String, TextView> entry : mActiveViews.entrySet()) {
          System.out.println(entry.getKey() + "/" + entry.getValue());
    }
    /* Another sample with getting specific TextView
     * by your Content Description (Key) 
     */
    System.out.println(mActiveViews.get("a" + dbid));
 }