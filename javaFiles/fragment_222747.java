public class pair implements Comparable<pair> {

            int a,b;
            @Override
            public int compareTo(pair o) {
                return(o.b-b); 
            }

            public pair(int a,int b) {

               this.a = a ;
               this.b = b;

            }

            public String toString() {
                return "("+a+","+b+")";

            }


            public static void main(String[] args) {

                 ArrayList pairs =  new ArrayList();
                 pairs.add(new pair(4,5));
                 pairs.add(new pair(7,8));
                 pairs.add(new pair(1,3));
                 Collections.sort(pairs);
                 System.out.println("sorted: "+pairs);

            }


        }