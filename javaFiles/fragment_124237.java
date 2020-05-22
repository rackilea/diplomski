public static class Node implements Comparable<Node>{
    int ID;
    String name;
    int age;

    //order by name
    public int compareTo( Node o ){
        if(name.equals(o.name)){
            return age - o.age;
        }
        return name.compareTo(o.name);
    }
}
 public static void main(String []args){

    LinkedList<Node> list = new LinkedList<Node>();
    //insert data...

    Collections.sort(list);
    int i = 1;
    while(i < list.size()){
        Node a = list.get(i-1);
        Node b = list.get(i);
        if( a.name.equals(b.name) && a.age == b.age ){
            list.remove(i);
        }else{
            i++;
        }
    }
 }