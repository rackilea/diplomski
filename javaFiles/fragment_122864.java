...
AtomicLong contador1 = new AtomicLong();
AtomicLong contador2 = new AtomicLong(500);
...

public void paint(Graphics g){
    g.drawString(Long.toString(contador1.get()), 80, 100);
    g.drawString(Long.toString(contador2.get()), 80, 120);
}

public void suma(Thread h, AtomicLong c){
    ...
        System.out.println(c);
        c.incrementAndGet();
        repaint();
    ...
}