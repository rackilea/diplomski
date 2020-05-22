public List<ISynsetID> getListHypernym(ISynsetID sid_pa) throws IOException {
    IDictionary dict = openDictionary();
    dict.open(); //Open the dictionary to start looking for LEMMA
    List<ISynsetID> hypernym_list = new ArrayList<>();

    boolean end = false;

    while (!end) {
        hypernym_list.add(sid_pa);
        List<ISynsetID> hypernym_tmp = dict.getSynset(sid_pa).getRelatedSynsets(Pointer.HYPERNYM);
        if (hypernym_tmp.isEmpty()) {
            end = true;
        } else {
            sid_pa = hypernym_tmp.get(0);//we will stick with the first hypernym
        }

    }

    //for(int i =0; i< hypernym_list.size();i++){
    //    System.out.println(hypernym_list.get(i));
    //}
    return hyp;
}