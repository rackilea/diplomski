private static Hashtable<Integer, MyObject> objectInstances = 
             new Hashtable<Integer, MyObject>();


    public static MyObject instance(int i1, int i2, int i3, int i4){
         int hashKey = Arrays.hashCode(new int[]{i1, i2,i3,i4});
         //get the object from hashtable
         MyObject myObject = objectInstances.get(hashKey);

         //if object was not already created, create now and put in the hashtable
         if(myObject == null){
           myObject = new MyObject(i1,i2,i3,i4);
           objectInstances.put(hashKey, myObject);
         }
        return myObject;
    }