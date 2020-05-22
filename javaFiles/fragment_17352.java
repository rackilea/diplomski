import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Partition {


    public static class WareHouse {

          int startTime;
          int endTime;

          public WareHouse(int i, int j) {
              startTime=i;
              endTime=j;
          }
    }


    public static class Agent {
        int end;

        public Agent() {

        }

        public boolean isCompWith(WareHouse x) {
            return end <=x.startTime;
        }

        public void schedule(WareHouse x) {
            end=x.endTime;
        }

    }

    public static void main(String...args) {
        WareHouse w1 = new WareHouse(2, 4);
        WareHouse w2 = new WareHouse(1, 2);
        WareHouse w3 = new WareHouse(3, 6);
        WareHouse w4 = new WareHouse(10, 11);
        WareHouse w5 = new WareHouse(9, 11);
        List<WareHouse> wareHouses = new ArrayList<WareHouse>();
        wareHouses.add(w1);
        wareHouses.add(w2);
        wareHouses.add(w3);
        wareHouses.add(w4);
        wareHouses.add(w5);
        Collections.sort(wareHouses, new Comparator<WareHouse> (){
            public int compare(WareHouse x, WareHouse y) {
                return x.startTime - y.startTime;
            }
        });
        PriorityQueue<Agent> queue = 
                new PriorityQueue<Agent>(new Comparator<Agent>() {
                    public int compare(Agent x, Agent y) {
                        return x.end- y.end;
                    }
                });
        for(WareHouse x: wareHouses) {
            Agent a = queue.poll();
            if(a==null) {
                a=new Agent();
                a.schedule(x);
                queue.add(a);
            } 
            else if (a.isCompWith(x)) {
                a.schedule(x);
                queue.add(a);
            } else {
                Agent b = new Agent();
                b.schedule(x);
                queue.add(a);
                queue.add(b);
            }
        }
        System.out.println(queue.size());
    }