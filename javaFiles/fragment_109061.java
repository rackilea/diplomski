@XmlRootElement
public class Type2{

    private List<Type1> type1s;

    @XmlElement
    public List<Type1> getType1s(){
        return this.type1s;
    }

    public void setType1s(List<Type1> type1s){
        this.type1s= type1s;
    }
}