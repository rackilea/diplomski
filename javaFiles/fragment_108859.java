for (Iterator<TestCls> iter = tstArry.iterator(); iter.hasNext(); ) {
    TextCls testCls = iter.next();
    if(testCls.getVal1().equals("a1")) {
        iter.remove();
    }
}