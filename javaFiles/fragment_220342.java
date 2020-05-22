Hashtable h = new Hashtable();
Hashtable h1 = new Hashtable();
Hashtable h2 = new Hashtable();
Set s = h.keySet();
int i = 0;
for (Object key : s) {
    if ( i++ < 3) {
        h1.put(key, h.get(key));
    } else {
        h2.put(key, h.get(key));
    }
}