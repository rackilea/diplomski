@Override
public String render(ProxyListPlace object) {
    String label = super.render(object);
    if(label == null) {
         if (SomeEntityProxy.class.equals(object.getProxyClass())) {
             label = "Some activity";
         }
     }
     return label;
}