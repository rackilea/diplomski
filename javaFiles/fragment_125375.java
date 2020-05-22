@Override
public void validate() {

    List<String> list = new ArrayList<String>();

    // For : 
    //  i. Props[]     : obj.getProps()[i].getName()
    // ii. List<Props> : obj.getProps().get(i).getName()

    // 1. names is mandatory fields (with requiredstring validator)
    // foreach () {
    //      list.add(obj.getProps[i].getName().trim());
    // }

    // 2. names is non-mandatory fields
    // foreach () {
    //      String name = obj.getProps[i].getName().trim();
    //      if(!name.isEmpty())
    //          list.add(name);
    // }

    Set<String> set = new HashSet<String>(list);

    if (set.size() < list.size()) {
        addActionError(getText("create.obj.error.propsdiff"));
    }
}