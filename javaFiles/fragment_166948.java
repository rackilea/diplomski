class Drinks{
String name;
int i;
double d1,d2;

public Drinks(String name, double d1, int i,  double d2) {
    super();
    this.name = name;
    this.i = i;
    this.d1 = d1;
    this.d2 = d2;
}

@Override
public String toString() {
    return "Drinks [name=" + name + ", i=" + i + ", d1=" + d1 + ", d2=" + d2 + 

"]";
    }
}

public class ArrayEg {
    public static void main(String[] args) {
        Drinks[] gtrk = new Drinks[] {
                new Drinks("Drink1",            0.90,      205,        0.5 ),
                new Drinks("Drink2",            0.90,      190,        0.5 ),
                new Drinks("Drink3",            0.70,      150,        0.5 ),
                new Drinks("Drink4",            20.50,     500,        2.0 ),
                new Drinks("Drink5",            28.70,     360,        1.5 ),
                new Drinks("Drink6",            6.90,      2500,       12.0 )
            };
        Object[] obj = new Object[gtrk.length];
        System.arraycopy(gtrk, 0, obj , 0, gtrk.length);
        for(Object o:obj){
            System.out.print((Drinks)o);    
        }
    }
}