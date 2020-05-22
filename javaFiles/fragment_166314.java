DumperOptions options = new DumperOptions();
options.setDefaultFlowStyle(DumperOptions.FlowStyle.AUTO);

Yaml yaml2 = new Yaml(new Representer() {
    @Override
    protected Node representMapping(Tag tag, Map<?, ?> mapping, Boolean flowStyle) {
        return super.representMapping(tag, mapping, false);
    }
},options);
String style2 = yaml2.dump(map);
System.out.println(style2);