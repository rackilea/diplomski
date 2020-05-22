addItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(itemBox.getSelectedItem().toString().equals("test1")) {
                addLowerPane.add(new Button("Lolonator"));
                revalidate();
            }

        }
    });;