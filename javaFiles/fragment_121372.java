if(result == 1){
        initialScreenDecisions="NONE";
        MainWriter.finishedCounter=true;
        System.out.println(MainWriter.finishedCounter);
        while(MainWriter.entryDetails.size()>0){
            MainWriter.entryDetails.remove(0);
        }
        while(output.size()>0){
            output.remove(0);
        }
    }