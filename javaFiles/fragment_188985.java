List<Object> newList = new ArrayList<Object>();

for (int i = 0; i < data.size() /* - 1 */ ; i++) {
    if (!newList.contains(data.get(i)))
        newList.add( /* 0, */ (data.get(i)));
}

return newList;