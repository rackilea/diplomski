if (pCoeff.size() > thisCoeff.size()) {
    difference = pCoeff.size() - thisCoeff.size();
    int limit = thisCoeff.size() + difference;
    for (int i = thisCoeff.size(); i < limit; i++) {
        thisCoeff.add(i, new Double(0.0));
    }
}