GroupLayout gl = new GroupLayout(getContentPane());
    this.getContentPane().setLayout(gl);

    pnCompo.setPreferredSize(new Dimension(300,300));
    pnCompo.setBorder(BorderFactory.createTitledBorder("More Components"));
    gl.setHorizontalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup()
                    .addGroup(gl.createSequentialGroup().addComponent(lbText)
                    .addComponent(txText))

             .addGroup(gl.createParallelGroup()
                     .addGroup(gl.createSequentialGroup().addComponent(lbText2)
                    .addComponent(txText2))

             .addComponent(pnCompo))
             )
    );
    gl.setVerticalGroup(gl.createSequentialGroup()
             .addGroup(gl.createParallelGroup()
                    .addComponent(lbText)
                    .addComponent(txText))
             .addGroup(gl.createParallelGroup().addComponent(lbText2)
                    .addComponent(txText2)
            )
            .addComponent(pnCompo)
    );
    pack();