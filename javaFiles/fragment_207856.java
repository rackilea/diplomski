//(...)
    List<Companions> companionsList = adUnitSizes.getCompanions();
    iterateOverCompanions(companionsList);
}

private void iterateOverCompanions(List<Companions> companionsList) {
    for(Companions companion : companionsList) {
        //Do stuff with companion
        List<Companions> anotherCompanionList = companion.getCompanionsList();
        if (anotherCompanionList  != null && anotherCompanionList.size()>0) {
            iterateOverCompanions(anotherCompanionList);
        }
    }
}