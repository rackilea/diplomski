for (int i = 0; i < professionList.size(); i++) {
    Profession profession = professionList.get(i);
    if (profession.isSelected()) {
        getProfessions.add(profession.getName());
       }
}
Bundle setProfessions = new Bundle();
setProfessions.putStringArrayList("String", getProfessions);
personalInfoFragment.setArguments(setProfessions);
replaceFragment();