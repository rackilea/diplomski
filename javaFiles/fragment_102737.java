for (int i = 0; i < deskLabels.length; i++) {
                deskLabels[i] = new JLabel();
                if ((i % 12) != 100) deskLabels[i].setText("" + i);
                else deskLabels[i].setText("  ");
                layoutPanel.add(deskLabels[i]);
     }