for (int i = 0; i < 14; i++) {
    final int currentI = i;
    buttons[i].setOnClickListener(new Button.OnClickListener() {
        public void onClick(View v) {
            // issue is with i value here
            move.makeMove(move.cups.get(currentI);
            updateButtons();
        }
    });
    currentCup = nextCup; 
}