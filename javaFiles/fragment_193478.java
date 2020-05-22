@Override
public void mousePressed(MouseEvent e) {
    Object source = e.getSource();
    int index = -1;

    for (int i = 0; i < numbers.length; numbers++) {
        if (numbers[i] == source) {
            index = i;
            break;
        }
    }
}

// here index either == the array item of interest or -1 if no match