public class Attribute {
    protected ArrayList<Attribute> attributes = new ArrayList<Attribute>();

    public Attribute(){
         //holding an array of yourself seems strange, but I am replicating the code in the question
         attributes.add(this);
    }

    public Iterator<? extends Attribute> iterator() {
        return this.attributes.iterator();
    }

    public static void main(String[] args){
        Attribute attribute=new Attribute();
        Iterator<? extends Attribute> it1=attribute.iterator();
        Attribute attributeInternat=it1.next();

        Attr attr=new Attr();
        Iterator<? extends Attr> it2=attr.iterator();
        Attr attrInternat=it2.next();
    }
}

public class Attr extends Attribute{
   protected ArrayList<Attr> attrs2 = new ArrayList<Attr>();
    public Attr(){
          //holding an array of yourself seems strange, but I am replicating the code in the question
          attrs2.add(this);
    }

    @Override
    public Iterator<? extends Attr> iterator() {
        return this.attrs2.iterator();
    }
}