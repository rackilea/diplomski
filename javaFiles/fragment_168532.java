public class Element {
    private String name;
    private String id;

    public Element(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Element){
            Element element = (Element) obj;
            if(element != null && this.name.equals(element.name) && this.id.equals(element.id)){
                return true;
            }
        }
        return false;
    }
  }