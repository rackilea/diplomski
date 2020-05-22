static HashMap<Integer, String> catnamecatkeys = new HashMap<Integer, String>();

static HashMap<Integer, String> keywords = new HashMap<Integer, String>();

static HashMap<String, String> tempHash = new HashMap<String, String>();

static HashMap<String, String[]> hash = new HashMap<String, String[]>();

static String[] arr;
public static void main(String[] agrs)
{     
   catnamecatkeys.put(1, "e1");
        catnamecatkeys.put(2, "e2");
        keywords.put(1, "word1-word2-word3");
        keywords.put(2, "word4-word5-word6");

        for (int key : catnamecatkeys.keySet()) {
            tempHash.put(catnamecatkeys.get(key),null);
        }
     Set<Entry<Integer,String>> set =  keywords.entrySet();
      Iterator<Entry<Integer, String>>  iterator= set.iterator();
        for(String tempkey: tempHash.keySet()){          
            tempHash.put(tempkey,iterator.next().getValue());
            arr = tempHash.get(tempkey).split("-");
            hash.put(tempkey, arr);
        }
        System.out.println(tempHash);
        for (String hashkey : hash.keySet()) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(hashkey + ":" + hash.get(hashkey)[i]);
            }


           }
}