public Circle {

    private int x;
    private int y;
    private int size;

    public void paint(Graphics g) {
        g.drawOval(x + size/2, y + size/2, size, size);
    }

    public void grow(){
        size++;
    }

    public void shrink(){
        size--;
        size = Math.max(size,1);
    }

}