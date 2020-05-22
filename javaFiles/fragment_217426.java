XStream xstream = new XStream();

NewParent newParent = new NewParent();
OldParentWithoutC oldParent = (OldParentWithoutC) xstream.fromXML(xml);
OldChild oldChild = (OldChild) xstream.fromXML(xml);

newParent.setObjectC(oldChild.getC());
String xml = xstream.toXML(newParent);