editMI.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.print(new CarTableModel(carsList).getCar(carTable.getSelectedRow())+"\n");
                    }
                });