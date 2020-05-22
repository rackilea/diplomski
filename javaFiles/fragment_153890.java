public void addToList(List<? super MyEnum> list) {
    list.add(MyEnum.VALUE_ONE);
}

addToList(new ArrayList<MyEnum>());
addToList(new ArrayList<MyEnumInterface>());