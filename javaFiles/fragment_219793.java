boolean listCheck(ArrayList allElements, ArrayList randomElements){
    int count = 0;
        for(Element a: allElements){
            for(Element b : randomElements){
                if(a==b){
                    count++;
                }
            }
        }
    return count==3;
}