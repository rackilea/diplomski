public class EqualsHashcode {

    public static void main(String[] args) {
        Test s = new Test("bharat", 1);
        Test p = new Test("bharat", 1);
        Test q = new Test("bharat", 2);
        Test r = new Test("bhara", 1);
        Hashtable ht = new Hashtable();
        ht.put(s, "1");
        ht.put(p, "1");
    }

}

class Test {
    String p;
    int i;

    Test(String s, int j) {
        p = s;
        i = j;
    }

    public String toString() {
        System.out.println(p + ".." + i);
        return p + " Hashcode is" + p.hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Test) {
            Test t = (Test) o;
            if (this.p.equals(t.p) && this.i == t.i) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        System.out.println(this);
        System.out.println("Calling hashCode" + " " + this.p.hashCode() + this.i);
        return this.p.hashCode() + this.i;
    }
}