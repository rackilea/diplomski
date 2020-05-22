private void printAnyArray(Object aObject) {
    if (aObject.getClass().isArray()) {
        if (aObject instanceof Object[]) // can we cast to Object[]
            System.out.println(Arrays.toString((Object[]) aObject));
        else {  // we can't cast to Object[] - case of primitive arrays
            int length = Array.getLength(aObject);
            Object[] objArr = new Object[length];
            for (int i=0; i<length; i++)
                objArr[i] =  Array.get(aObject, i);
            System.out.println(Arrays.toString(objArr));
        }
    }
}