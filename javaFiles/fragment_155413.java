jButton1.addActionListener(new ActionListener () {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            System.out.println("outside Action");
            jButton1.addActionListener(new ActionListener () {
                public void actionPerformed(java.awt.event.ActionEvent evt2) {
                    System.out.println("inside Action");
                }
            });
        }
   });