public ArrayList<String> arrayList;

@Override
protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    arrayList=new ArrayList<String>();

    String[] letters = {"G","O","K","U","H","A","N","L","Z","M"};
    for (String s:letters)
      arrayList.add(s);



    c1r1.setText("" + getRandom());
    c2r1.setText("" + getRandom());
    ...
    ...

}


public String getRandom(){

    String randomString=arrayList.get(random.nextInt(arrayList.size()));
    arrayList.remove(randomString);
    return randomString;

}