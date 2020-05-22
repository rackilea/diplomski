String [] values = new String [TraitList.size()];
{
    for (int jln = 0; jln < TraitList.size(); jln++){
        values [jln] = (TraitList.get(jln).id + " - " + TraitList.get(jln).Name);
    }
}