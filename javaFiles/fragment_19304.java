setLayout(new MigLayout());
add(button1);
add(button2);
add(button3);
add(button4);
add(button5, "wrap");
add(list, "span, growx, growy, wrap");

// merge 4 cells then split the combined cell in half
// label goes in the first cell of the split
// spinner goes in the second cell of the split
add(label, "span 4, split 2);
add(spinner);
// check box goes in the 5th and final cell of the row (after the 4 merged cells)
add(checkBox, "align right");