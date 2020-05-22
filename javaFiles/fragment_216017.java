OleAutomation active = activeDocument.getAutomation();
    if(active!=null){
    int[] paragraphsId = getId(active, "Paragraphs");
    if(paragraphsId.length > 0) {
        Variant vParagraphs = active.getProperty(paragraphsId[0]);
        if(vParagraphs != null){
            OleAutomation paragraphs = vParagraphs.getAutomation();
            if(paragraphs!=null){
                int[] countId = getId(paragraphs, "Count");
                if(countId.length > 0) {
                    Variant count = paragraphs.getProperty(countId[0]);
                    if(count!=null){
                        int numberOfParagraphs = count.getInt();
                        for(int i = 1 ; i <= numberOfParagraphs ; i++) {
                            Variant paragraph = paragraphs.invoke(0, new Variant[]{new Variant(i)});
                            if(paragraph!=null){
                                System.out.println("paragraph " + i + " added to list!");
                                listOfParagraphs.add(paragraph);
                            }
                        }
                        return listOfParagraphs;
                    }
                }
            }
        }
    }