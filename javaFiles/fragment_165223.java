while (post != null) {
    if (prev.next.val != curr.val || prev.next.val != post.val) {
        if (prev.next.val == curr.val) {
            prev.next = curr.next;
        } else {
            prev = prev.next;
        }
    }
    curr = curr.next;
    post = post.next;
}