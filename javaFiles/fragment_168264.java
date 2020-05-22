public class rnd_0001 {

private Map<String, int[]> arg0 = new HashMap<>();
private Map<String, Integer> arg1 = new HashMap<>();
private Map<String, Integer> arg2 = new HashMap<>();

private int lookupArg1(String s){
    if(!arg1.containsKey(s))
        arg1.put(s, arg1.size());
    return arg1.get(s);
}

private int lookupArg2(String s){
    if(!arg2.containsKey(s))
        arg2.put(s, arg2.size());
    return arg2.get(s);
}

public void add(String uniqueData, String arg1, String arg2){
    int arg1ID = lookupArg1(arg1);
    int arg2ID = lookupArg2(arg2);
    arg0.put(uniqueData, new int[]{arg1ID, arg2ID});
}

public void changeArg1(String orig, String replacement){
    if(!arg1.containsKey(orig))
        return;
    if(replacement.equals(orig))
        return;
    arg1.put(replacement, arg1.get(orig));
    arg1.remove(orig);
}

public void changeArg2(String orig, String replacement){
    if(!arg2.containsKey(orig))
        return;
    if(replacement.equals(orig))
        return;
    arg2.put(replacement, arg2.get(orig));
    arg2.remove(orig);
}

private String reverseLookupArg1(int id){
    for(Map.Entry<String, Integer> en : arg1.entrySet())
        if(en.getValue() == id)
            return en.getKey();
    return null;
}

private String reverseLookupArg2(int id){
    for(Map.Entry<String, Integer> en : arg2.entrySet())
        if(en.getValue() == id)
            return en.getKey();
    return null;
}

public void change(String uniqueData, String arg1, String arg2){
    if(!arg0.containsKey(uniqueData))
        return;
    int arg1ID = arg0.get(uniqueData)[0];
    int arg2ID = arg0.get(uniqueData)[1];
    changeArg1(reverseLookupArg1(arg1ID), arg1);
    changeArg2(reverseLookupArg2(arg2ID), arg2);
}

public void output(){
    for(Map.Entry<String, int[]> key : arg0.entrySet()){
        System.out.println(key.getKey() + "\t" + reverseLookupArg1(key.getValue()[0]) + "\t" + reverseLookupArg2(key.getValue()[1]));
    }
}

public static void main(String[] args){
    rnd_0001 datastructure = new rnd_0001();

    datastructure.add("obj1","hello", "world");
    datastructure.add("obj2", "hello", "everyone");
    datastructure.output();
    System.out.println("");

    datastructure.change("obj1", "hell", "world");
    datastructure.output();
}