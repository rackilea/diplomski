if(e.getSource() == addSpell){
        ArrayList<Spell> temp = new ArrayList<Spell>();
        for(Spell spell: SpellList.getSpellList()){
            if(spell.getType().equals(user.getType())){
                temp.add(spell);
            }
            //LINES MOVED FROM HERE
        }
        //LINES MOVED TO HERE
        new SpellArraySorter(temp, this);
        this.setVisible(false);