Node last = First;
int distance = 0;
for(Node pos = First; pos != null; pos=pos.Next) {
    distance += pos.Space;
    last = pos;
}
last.Next = new Node(the_letter_for_this_car, MaxDistance-distance, null);