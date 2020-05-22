public interface AddToParam4ListStep {
    AddToParam4ListOrBuild add(Integer toAdd);
}

public interface AddToParam4ListOrBuild {
    AddToParam4ListOrBuild add(Integer toAdd);
    ComplexObject build();
}