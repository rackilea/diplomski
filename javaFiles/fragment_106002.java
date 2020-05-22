Component[] c = new Component[10];
    for(int i=0;i<10;i++)
    {
        c[i] = new JMenuItem(""+i);
    }
    JMenuItem j[] = java.util.Arrays.copyOf(c, c.length, JMenuItem[].class);