Current = head;
prev = null;
int ans =0;
while(current !=null){
     prev = current;
     current = current.next;
     if(current.next == null){
        prev.next = null
        ans = current.val;
        break;
     }
}
return ans;