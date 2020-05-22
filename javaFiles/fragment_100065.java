@Override
    public Paint transform(RDFNode i) {

        OntModel model = (OntModel) i.getModel();
        Collection classes = JenaJungGraph.asCollection(model.listClasses());

        if(classes.stream().anyMatch(x -> x.toString() == i.asResource().toString())) return ontPropertyColor;

        return Color.GRAY;
    }