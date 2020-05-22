for (int i = seqsizemin;i<=seqsizemax;i++) {
        if (SeqNrList.contains(i+"")) {
            System.out.println("Sequence " + i + " ok");
        } else {
            System.out.println("Sequence " + i + " Missing");
        }
    }