List userErrorlist = new ArrayList();
List adminErrorList = new ArrayList(userErrorlist.size() + 1);


adminErrorList.add(newElement);
adminErrorList.addAll(userErrorlist);