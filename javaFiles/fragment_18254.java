for (int i = 0; i < treeList.size(); i++) {
    JUCtrlHierNodeBinding treeNode = treeList.get(i);
    Object[] treeAttrList = treeNode.getAttributes();
    for (int m = 0; m < treeAttrList.length ; m++) {
        Object attr = treeAttrList[m];
        if (attr instanceof java.lang.Long) {writer.write(((Long)attr).toString()); writer.write(","); }
        if (attr instanceof java.lang.String) {writer.write(((String)attr)); writer.write(","); }
    }
    //writer.newLine();
    List<JUCtrlHierNodeBinding> subList = treeNode.getChildren();
    if(subList!=null) {
        for (int j = 0; j < subList.size(); j++) {
            JUCtrlHierNodeBinding subNode = subList.get(j);
            Object[] subAttrList = subNode.getAttributes();
            writer.write(",");writer.write(",");writer.write(",");writer.write(",");

            for (int n = 0; n < subAttrList.length ; n++) {
                Object subAttr = subAttrList[n];
                if(subAttr instanceof java.lang.Long) { writer.write(((Long)subAttr).toString()); writer.write(","); }
                if(subAttr instanceof java.lang.String) { writer.write(((String)subAttr)); writer.write(","); }
                if(subAttr instanceof oracle.jbo.domain.Date) { writer.write(((oracle.jbo.domain.Date)subAttr).stringValue()); writer.write(","); }             
            }
            writer.newLine();               
        }
    }
    writer.newLine();
}
writer.flush();
}