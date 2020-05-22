if (clicked[0] != -1 && clicked[1] != -1) 
{
    int temp = table[clicked[0]];
    table[clicked[0]] = table[clicked[1]];
    table[clicked[1]] = temp;

    // get button references from array using index -> set swapped background color
    buttons[clicked[0]].setBackground(color[table[clicked[0]]]);
    buttons[clicked[1]].setBackground(color[table[clicked[1]]]);

    clicked[0] = -1;
    clicked[1] = -1;
}