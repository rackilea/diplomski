int i = top_half.length - 1;
int j = bottom_half.length - 1;
int index = 51;
while (index >= 0) {
    card_force[index--] = top_half[i--];
    card_force[index--] = bottom_half[j--];
}