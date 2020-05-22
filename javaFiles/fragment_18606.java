int size=list.size();
for (int i = 0; i < sum.size(); i++) {
    boolean found = false;
    for (int j=0; j<size ;j++) {
        if (list.get(j).getId().equals(sum.get(i).getId())) {
            list.get(j).setNumber(sum.get(i).getNumber());
            found = true;
            break;
        }
    }
    if (!found) {
        list.add(new Factor(sum.get(i).getId(),sum.get(i).getCat(), sum.get(i).getKind(),
                                            sum.get(i).getName(), sum.get(i).getNumber()));

    }
}