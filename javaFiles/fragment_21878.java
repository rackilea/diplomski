p = new JButton("Go");
p.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello");
        ne.remove(p);
        ne.revalidate();
        ne.repaint();
        System.out.println("why" + EventQueue.isDispatchThread());
        b = false;
        System.out.println(b);
    }
});
p.setEnabled(false);