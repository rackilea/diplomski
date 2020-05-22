List<String> listNames = new ArrayList<String>();//global variable

List<History> history = db.getAllHistory();
    for (History cn : history) {
         listNames.add(cn.getName());
    }