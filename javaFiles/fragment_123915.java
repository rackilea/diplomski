int startFrom = arrayList.size() - 3;
int upTo = arrayList.size();
int incrBy = 2;

for (int i = startFrom; i < upTo && i < arrayList.size(); i += 1) {
    int oldValue = arrayList.get(i);
    int newValue = oldValue + incrBy;
    arrayList.set(i, newValue);
}