List current = next;
int last = value;//Set to the current value to begin with
while(current != null) {
   last = current.value;
   current = current.next;
}
return last;