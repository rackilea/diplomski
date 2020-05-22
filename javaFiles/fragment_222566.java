public class StackUsingQPartII implements Iterable<Integer>{

        @Override
        public Iterator<Integer> iterator() {
            return q1.iterator();
        }

        public static void main(String[] args) {

            StackUsingQPartII st = new StackUsingQPartII();
            st.push(2);

            Iterator<Integer> it = st.iterator();
            while (it.hasNext()) {
                Integer i = it.next();
                System.out.println(i);
            }
       }
}