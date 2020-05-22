x=new java.util.HashMap();
x.put("foo","bar");
x.put("bat","bif");
x.put("barf","boo");

var keyArray = x.keySet().toArray();
for(var i=0, l = keyArray.length; i < l; i++){
    var key = keyArray[i]; 
    var value = x.get(key);
    print(value);
}