for(int a = 0 ; a < strArray.length ; a++){
            FRUIT[a] = Dictionary.getInstance().getIndexWord(POS.NOUN, hyp[a]);
        }

        for(int b = 0 ; b < FRUIT.length  ; b++){
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add(hyp[b]);

            PointerTargetTree printlist= demonstrateListOperation(FRUIT[b]);
            //printlist.print();
            PointerTargetNodeList ppt = printlist.getRootNode().getChildTreeList();
        string is ArrayList type
            ListClass temp = new ListClass();
            temp.string_list = getHypernymTerm(ppt, arrayList, hyp[b]);