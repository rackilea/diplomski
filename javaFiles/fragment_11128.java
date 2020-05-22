private void placeComponents() {
    JPanel p = new JPanel(new GridLayout(3, 3)); 
    for (int i = 0; i < 9; i++) {
        JPanel q = new JPanel(); {
            q.add(candidates[i]);
        }
        q.setOpaque(false);
        p.add(q);  
    }

    p.setOpaque(false);
    add(p, CANDIDATES); // was DIGIT

    p = new JPanel(new GridBagLayout()); {
        p.add(digit, gridBagConstraint);
        p.setOpaque(false);
    }
    add(p, DIGIT); // was CANDIDATES
}