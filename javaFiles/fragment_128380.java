public void draw() {
            this.getContentPane().removeAll();
            int count;
            JPanel Panel = new JPanel();
            GridLayout layout=new GridLayout(0, 1);
            Panel.setLayout(layout);
            JLabel label2 = new JLabel("Text-Only Label");
            Panel.add(label2);
            this.getContentPane().add(Panel);
            this.validate();
            this.repaint();
        }