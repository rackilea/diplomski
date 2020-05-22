while (true){
    // lol2 here is TRUE if was entered correct value and false if not.
    if (lol2)
        break;
    else {
        JOptionPane.showMessageDialog(frame, "Quantità non disponibile");
        this.addToCart(cart,quant);
    }
}