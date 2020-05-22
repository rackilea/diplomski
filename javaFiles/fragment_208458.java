public List<String> getMyList() {
        myList.clear();
        List<String> list = (List<String>) AdfFacesContext.getCurrentInstance().getProcessScope().get("myList");
        if (list != null) {
            for (String var : list) {
                myList.add(var);
            }
        }
        return myList;
    }