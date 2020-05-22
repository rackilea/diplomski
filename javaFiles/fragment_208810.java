public void setPrimaryForPosition(int position, int newPrimary) {

    for (int j=0;j<CardsNewFragment.card_list.size();j++) {
        if(j+1==position) {
            CardsNewFragment.card_list.get(j).setPrimary(newPrimary);
        } else {
            CardsNewFragment.card_list.get(j).setPrimary(0);
        }
    }

}