for (String tk:instance.keySet()) {
    svm_node n=new svm_node();
    System.out.println(tk + " "+ instance.get(tk));

    if (IndexDic.containsKey(tk)) {
        n.index = (IndexDic.get(tk));
        n.value = instance.get(tk);
        nodes.add(n);
    }
    else {
        System.out.println("does not contain"+tk);
    }
}