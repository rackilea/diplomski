/*       \/  This Part  \/       */

        JButton replace = new JButton("Replace");
            replace.setFont(new Font("Verdana", Font.PLAIN, w/80));
            replace.setSize(new Dimension(w/8,h/8));
            replace.addActionListener(new ActionListener(){  /*********************/
                public void actionPerformed(ActionEvent e){        /* Added this action */
                    replaceButtonClicked();                        /*  listener and it  */
                }                                                  /*   all broke :3    */
            });                                                    /*********************/
        JButton cancel = new JButton("Cancel");
            cancel.setFont(new Font("Verdana", Font.PLAIN, w/80));
            cancel.setSize(new Dimension(w/8,h/8));
            cancel.addActionListener(new ActionListener(){   /*********************/
                public void actionPerformed(ActionEvent e){        /* Added this action */
                    cancelButtonClicked();                         /*  listener and it  */
                }                                                  /*   all broke :3    */
            });                                                    /*********************/

        /*       /\  This Part  /\       */