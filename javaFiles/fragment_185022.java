public ArrayList<MyObject> convertArrayCollection(ArrayCollection array){
        ArrayList<MyObject> myObjectArray = new ArrayList();
        ASTranslator ast = new ASTranslator();
        MyObject myObject;
        ASObject aso;

        for (int i=0;i< array.size(); i++){
            myObject = new MyObject();
            aso = new ASObject();

            aso = (ASObject) array.get(i);
            aso.setType("com.myPackage.MyObject");
            myObject = (MyObject) ast.convert(aso, MyObject.class);
            myObjectArray.add(myObject);
        }
        return myObjectArray;
    }