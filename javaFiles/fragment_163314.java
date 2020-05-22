public abstract class SomeAbstractClass{
    protected String a;
    protected String b;

    /* Constructor */
    public SomeAbstractClass(String a, String b){
        this.a = a;
        this.b = b;
    }

    /* Abstract Getter 1 */
    public abstract String geta();

    /* Abstract Getter 2 */
    public abstract String getb();

}

public class concreteClass extends someAbstractClass{

    /* Constructor */
    public New(String a, String b){
        super(a,b);
    }

    /* Implementation of Getter 1 */
    @Override
    public String getA(){
        return this.a;
    }

    /* Implementation of Getter 2 */
    @Override
    public String getB(){
        return this.b;
    }
}