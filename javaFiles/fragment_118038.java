for(int filler = 0; filler <= 5; filler++) {   
    for(int filler2 = 0; filler2 <= 6; filler2++) {
        buttons[filler][filler2] = new Button(filler2, filler);
        frame.add(buttons[filler][filler2]);
        buttons[filler][filler2].addActionListener(this);
    }
}