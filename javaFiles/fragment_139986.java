public class Essence {
class SpecialArray{
 public <?> [3][3] array;

@Override
public int hashCode() { // eclipse can generate this two methods 
}

@Override
public boolean equals(Object obj) {
}


}
SpecialArray a = new SpecialArray();
SpecialArray b = new SpecialArray();
a.array[1][1] = x;// value
b.array[1][1] = x;// value
    a.equals(b); // true
}