x=new java.util.HashMap();
x.put("foo","bar");
x.put("bat","bif");
x.put("barf","boo");

var keyIter = x.keySet().iterator();
while(keyIter.hasNext()){
    var key = keyIter.next() 
    var value = x.get(key);
    print(value);
}