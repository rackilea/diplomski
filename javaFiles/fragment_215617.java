public static void addToList(LinkMaster<Entry> list, int n){//here n will determine number of entry node to be added
        for (int i = n; i>0; i--) { 
            Entry entry = new Entry(i);
            list.addToStart(entry);
        }
    }