SwingWorker worker = new SwingWorker()
    {
           @Override
           public object doInBackground() {
               GatheringFiles ob = new GatheringFiles();
               java.util.List list =   ob.returnlist(folder);
               return list;
           }

           @Override
           protected void done() {
               java.util.List list = (java.util.List)get();
               for(int x = 0; x < list.size(); x++)     
        {     
            dtm.addRow(new Object[]{new Boolean(false),list.get(x).toString()});     
        }     
        JPanel pan = new JPanel();
        JScrollPane sp = new JScrollPane(table);     
        TableColumn tc = table.getColumnModel().getColumn(0);     
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));     
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));     
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));     
        but = new JButton("REMOVE");
        JFrame f = new JFrame();     
        pan.add(sp); 
        but.move(650, 50);
        but.addActionListener(this);
        pan.add(but);

        f.add(pan);
        f.setSize(700, 100);
        f.pack();     
        f.setLocationRelativeTo(null);     
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        f.setVisible(true);  

        //hide the progress bar
           }
    }

worker.execute();
//show progress bar