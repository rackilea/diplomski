Comparator comparator1 = new Comparator<MyEnum>() {

  public int compare(MyEnum e1, MyEnum e2) {
     //your magic happens here
     if (...)
       return -1;
     else if (...)
       return 1;

     return 0;
  }
};

//and others for different ways of comparing them

//Then use one of them:
MyEnum[] allChemicals = MyEnum.values();
Arrays.sort(allChemicals, comparator1); //this is how you sort them according to the sort critiera in comparator1.