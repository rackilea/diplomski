for(int i = sb.length() - 2; i > 0; i--) { // inverse loop
    if(sb.charAt(i) == a) {
        // swapping
        sb.setCharAt(i, sb.charAt(i + 1));
        sb.setCharAt(i + 1, a);
    }
}