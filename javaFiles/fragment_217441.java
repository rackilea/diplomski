@Override
public int getCount() {
    return resultList.size() / 2;
}

@Override
public Object getItem(int index) {
    return resultList.get(index * 2 + 1);
}