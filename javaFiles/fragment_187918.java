Transformer<Integer, String> transformer = new Transformer<Integer, String>() {

    @Override
    public String transform(Integer arg0) {
    return arg0.toString();
    }

};
vv3.getRenderContext().setVertexLabelTransformer(transformer);