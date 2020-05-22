public class IntNode {

    int data;
    IntNode link;

    IntNode(){
        this.link = null ;
    }

    public IntNode(int initialData, IntNode initialLink)
    {
        data = initialData;
        link = initialLink ;
    }

    public void addNode(int element){
        link = new IntNode(element,link);
    }

    public int getData(){
        return data;
    }

    public IntNode getLink(){
        return link;
    }

    public void removeNodeAfter()
    {
        link = link.link;
    }

    public void setLink(IntNode newLink){
        link = newLink;
    }

    void insertAtHead(int input){
        input = data;
    }
    //this method doesnt work
    public int listLength(IntNode head){
        IntNode cursor = null;
        int ans;
        ans = 0;
        for(cursor=head; cursor!= null; cursor=cursor.link)
            ans++;
        return ans;
    }

    //this method doesnt work either
    public boolean find(IntNode head, int searchKey)
    {
        if(head == null){
            return false ;
        }
        IntNode current = head ;
        while(current != null){
            if(current.data == searchKey){
                return true ;
            }
            current = current.link ;
        }
        return false ;
    }
}

public class linkedList1 {

    public static void main(String[] args) {

            IntNode head ;
            IntNode tail ;

            head = new IntNode(10, null);
            head = new IntNode(20,head);
            head = new IntNode(25, head);
            head = new IntNode(30,head);

            IntNode cur = head;
            while(cur!= null){
                System.out.println(cur.data);
                cur= cur.link;
            }

            IntNode node = new IntNode();

            System.out.println(node.listLength(head));

            if(node.find(head, 20))
                System.out.println("found");

            else

                System.out.println("not found");


    }
}