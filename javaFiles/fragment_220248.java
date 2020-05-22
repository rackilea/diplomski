public void setCount(int newCount) {
    count = newCount;
    Icon icon = null;
    switch (count) {
    case 1:
        icon = red;
        break;
    case 2:
        icon = yellow;
        break;
    case 3: 
        icon = green;
        break;
    default:
        icon = null;
        break;
    }
    imageLabel.setIcon(icon);
}