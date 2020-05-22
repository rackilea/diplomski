public void insert(VideoGame s, int position) {
    if (null == list) {
        list = new VideoGameNode(s);
    } else {
        VideoGameNode current = list;
        int counter = 0;
        while (null != current.next && position > counter++)
            current = current.next;
        VideoGameNode newNode = new VideoGameNode(s);
        newNode.next = current.next;
        current.next = newNode;
    }
}