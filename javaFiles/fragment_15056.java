int total(Node point){
    if (point == null) return 0;
    switch (point.payload){
        case "+": return total(point.left) + total(point.right);
        case "-": return total(point.left) - total(point.right);
        case "/": return total(point.left) / total(point.right);
        case "*": return total(point.left) * total(point.right);
        default: return Integer.parseInt(point.payload);
    }
}