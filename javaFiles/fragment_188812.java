JFrame frame = new JFrame("GridLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        // Create the two grids
        JPanel grid1 = new JPanel(new GridLayout(2,2,2,2));
        JPanel grid2 = new JPanel(new GridLayout(2,2,2,2));

        // Create borders
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        CompoundBorder line = new CompoundBorder(empty, blackLine);
        Border grid1Border = BorderFactory.createTitledBorder(line, "Grid 1");
        Border grid2Border = BorderFactory.createTitledBorder(line, "Grid 2");

        //Grid 1
        grid1.add(new JButton("Button 1"));
        grid1.add(new JButton("Button 2"));
        grid1.add(new JButton("Button 3"));
        grid1.add(new JButton("Button 4"));
        grid1.setBorder(grid1Border); 

        //Grid 2
        grid2.add(new JButton("Button 5"));
        grid2.add(new JButton("Button 6"));
        grid2.add(new JButton("Button 7"));
        grid2.add(new JButton("Button 8"));
        grid2.setBorder(grid2Border);

        frame.getContentPane().add(grid1);
        frame.getContentPane().add(grid2);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);