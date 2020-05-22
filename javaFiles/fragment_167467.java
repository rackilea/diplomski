JPanel labelPanel = new JPanel( new GridLayout(0, 5) );

for (int i = 0; i < labels.length; i++) {
    for (int j = 0; j < labels[i].length; j++) {
        JLabel label = new JLabel(Character.toString(letters[i][j]));
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        labelPanel.add( label );
    }
}

add(labelPanel. BorderLayout.CENTER);