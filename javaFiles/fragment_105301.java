@XmlRootElement(name = "item")
class AnItem {

  MyFactory myFactory = Utils.getBean(MyFactory.class);

  ...
}