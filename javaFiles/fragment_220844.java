if (isSelected) {
    setOpaque(true); 
    setBackground(Color.GRAY);
} else {
    setOpaque(false); // allow underlying color to show
    setBackground(null); // no color added
}