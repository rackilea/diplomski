edgeName : your edge name

vv.getRenderContext().setEdgeLabelRenderer(new Transformer<String, String>()  {
    @Override
    public String transform(String edgeName) {
       String label;                
       //map your label to your edgeName
       return label;
    }
});