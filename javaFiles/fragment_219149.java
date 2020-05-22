JRadioButton jrb = new JRadioButton();
       int width = (int) SwingUtilities2.getFontMetrics( jrb, jrb.getFont() ).getStringBounds( cat.getDescription(), null ).getWidth();
       for (Case c : cases) {
            JRadioButton jrbCase = new JRadioButton();
            jrbCase.setText(c.getDescription());
            jrbCase.setToolTipText(c.getText());
            jrbCase.setPreferredSize( new Dimension( width, jrbCase.getPreferredSize().height ) );
            bgCases.add(jrbCase);
            jp.add(jrbCase);
        }