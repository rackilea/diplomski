public <T> T fromTheEnd(LinkList<T> ts, int idx) {
    Node<T> follower, leader;
    // We iterate until the leader hits the end of the list. follower follows leader
    // idx steps behind, so when leader.next = [], follower is the desired node.
    follower = leader = ts.first;
    for(int j = 0; j < idx; j++) {
        leader = leader.next;
    }
    // leader is now idx steps ahead
    while(leader.next != null) {
      leader = leader.next;
      follower = follower.next;
    }
    // leader has hit the end (next is null)
    // follower has your data
    return follower.t;
}