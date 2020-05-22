public void actionPerformed(ActionEvent e) {
            value = (String) combo.getSelectedItem().toString();
            if(value.equals("a")){
                panel.add(a.getLabel());
                panel.remove(b.getLabel());
                // add(panel);
                // pack();
            }else if(value.equals("b")){
                panel.add(b.getLabel());
                panel.remove(a.getLabel());
                // add(panel);
                // pack();
            }
            add(panel);
            revalidate();
            repaint();
        }