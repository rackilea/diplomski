public class A {

    public static void main(String[] args) {
        int[] arr = {6,1,3,5,2};
        int position = 5;
        Queue<Person> queue = new LinkedList<Person>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(new Person(i+1, arr[i]));
        }
        int count = 0;
        while(true){
            Person p = queue.remove();
            p.tickets--;
            count++;
            if(p.tickets == 0){
                if(p.position == position){
                    break;
                }
            }else{
                queue.add(p);
            }
        }
        System.out.println("Count: " + count);
    }

    static class Person{
        int position;
        int tickets;

        public Person(int position, int tickets){
            this.position = position;
            this.tickets = tickets;
        }
    }       
}