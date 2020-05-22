List<MyObj> list = new ArrayList<MyObj>();
int size = list.size();
for(int i = 0; i < size; i++) {
    MyObj mo = list.get(i);
    mo.doSomething();
    if (size > list.size()) {
        size = list.size();
        i--;
    }
}