@YourJAXBAnnotationsGoHere
public class MyAdapter{

  @XmlElement // or @XmlAttribute if you wish
  private String content;

  public MyAdapter(Object input){
    if(input instanceof String){
      content = (String)input;
    }else if(input instanceof YourFavoriteClass){
      content = ((YourFavoriteClass)input).convertSomehowToString();
    }else if(input instanceof .....){
      content = ((.....)input).convertSomehowToString();
    // and so on
    }else{
      content = input.toString();
    }
  }
}

// I would suggest to use a Map<Class<?>,IMyObjToStringConverter> ...
// to avoid nasty if-else-instanceof things