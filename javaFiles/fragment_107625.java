public static TestEnum fromDisplay(String display){
    for (TestEnum v : TestEnum.values()){
        if (v.getDisplay().equals(display)){
            return v;
        }
    }
    return null;
}