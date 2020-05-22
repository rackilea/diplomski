VelocityEngine ve = new VelocityEngine();
Properties props = new Properties();
props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
props.put("resource.loader", "class");
ve.init(props);
Template t = ve.getTemplate("templates/my-template.vm");

final List<String> keys = new ArrayList<String>();
SimpleNode sn = (SimpleNode)t.getData();
BaseVisitor myVisitor = new BaseVisitor(){
    @Override
    public Object visit(ASTReference node, Object data){
        String key = node.literal();
        keys.add(key);
        return super.visit(node, data);
    }
};
sn.jjtAccept(myVisitor, new Object());
for (String key : keys) {
    System.out.println(key);
}