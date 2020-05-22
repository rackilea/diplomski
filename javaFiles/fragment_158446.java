public void print() {
    NodeFN nn = new NodeFN(n);

    while(nn != null) {
        nn.getNext().getData();
        System.out.println(nn.getData() + " ");
    }
}