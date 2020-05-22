String one = "Android is awesome";
String two = "Android is";
    if(one.contains(two)){
        Log.i("remaining string ",one.split(two)[0].replace(" ",""));
        Log.i("remaining string ",one.split(two)[1].replace(" ",""));
    }else{
        Log.i("remaining string ","");
    }