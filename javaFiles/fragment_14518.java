import java.util.*;
    class Term
    {
        private int coe;
        private int pow;
        public int getCoe()
        {return coe;}
        public int getPow()
        {return pow;}
        public void setCoe(int coe)
        {this.coe=coe;}
        public void setPow(int pow)
        {this.pow=pow;}
        public Term(int coe, int pow)
        {
            this.coe=coe;
            this.pow=pow;
        }
        @Override
        public String toString()
        {
            return "(" +coe+ "," +pow+ ")";
        }
    }
    class Polynomial
    {
        private LinkedList poly;
        public Polynomial()
        {
            poly = new LinkedList();
        }
        public void addTerm(int coe, int pow)
        {
            Term t = new Term(coe,pow);
            poly.addLast(t);
        }
        public void print()
        {
            ListIterator iter = poly.listIterator();
            while(iter.hasNext())
            {
                Term temp = (Term) iter.next();
                System.out.print(temp);
            }
            System.out.println();
        }
        public void insert(int coe, int pow)
        {
            Term temp = new Term(coe,pow);
            ListIterator iter = poly.listIterator();

            while(iter.hasNext())
            {
                Term t = (Term)iter.next();
                if(t.getPow() == temp.getPow())
                {
                    t.setCoe(t.getCoe()+temp.getCoe());
                    return;
                }
                else if(t.getPow() < temp.getPow())
                {
                    iter.previous();
                    iter.add(temp);
                    return;
                }
                iter.add(temp);
            }
        }
            public Polynomial add(Polynomial p)
            {
                Polynomial a = new Polynomial();
                ListIterator iter = poly.listIterator();
                ListIterator pIter = p.poly.listIterator();

                while(iter.hasNext())
                {
                    Term t =(Term)pIter.next();
                    a.insert(t.getCoe(),t.getPow());
                }
                return a;
            }
            public Polynomial multiply(Polynomial p)
            {
                Polynomial m = new Polynomial();
                ListIterator iter = poly.listIterator();

                while (iter.hasNext())
                {
                    Term t = (Term)iter.next();
                    ListIterator pIter = (p.poly).listIterator();
                    while (pIter.hasNext())
                    {
                        Term temp = (Term)pIter.next();
                        m.insert(t.getCoe() * temp.getCoe(), t.getPow() + temp.getPow());
                    }
                }
                return m;
            }
        }

        public class PolynomialTest
        {
            public static void main (String [] args)
            {
                Polynomial p = new Polynomial();
                p.addTerm(-10,0);
                p.addTerm(-1,1);
                p.addTerm(9,7);
                p.addTerm(5,10);

                Polynomial p2;
                p2 = p.multiply(p);
                p2.print();
            }
        }