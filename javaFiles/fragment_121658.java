import java.util.ArrayList;
    import java.util.Iterator;

    public class Orders { 
        ArrayList list = new ArrayList();
        Iterator it = null;

        public void addOrder(String s) {
            it = list.iterator();
            while(it.hasNext()){
                String st = (String) it.next();
                if(s.equals(st)){
                    System.out.println("The order '"+s+"' already exists.");
                    return;
                }

            }


                list.add(s);
                System.out.println("Order '"+s+"' was added.");    


        }

        public void deleteOrder(String s) {
            it = list.iterator();
            while(it.hasNext()){
                String st = (String) it.next();
                if(s.equals(st)){
                    list.remove(s);
                    System.out.println("The order '"+s+"' was deleted succesfully.");
                    return ;
                }

            }
                System.out.println("The order '"+s+"' was not found.");

        }

        public void showList(){
            it = list.iterator();
            while(it.hasNext()){
                String st = (String) it.next();
                System.out.println("Order: '"+st+"'. \n");
            }
        }
    }