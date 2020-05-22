class MyGenClass {
    Number age;
    public <T extends Number> void setAge(T ageParam){
        age = ageParam;
    }
}