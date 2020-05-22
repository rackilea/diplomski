List<String> list = data.getList();
int oldSize = list.size();
data.insertElementToInternalData();

// Here, the client relies on the fact that he received
// a VIEW on the internal data:
int newSize = list.size();
assertTrue(newSize == oldSize+1);