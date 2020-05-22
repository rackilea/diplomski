int cartIdx = 0;
while (cartIdx < cartCapacity.length) {
    int cartOnBoard = 0; // this should be initialized for every cart
    String cartElements = ""; // this should be initialized for every cart
    for (int i = 0; i < cargoTons.length; i++) {
        if ((cartOnBoard + cargoTons[i]) <= cartCapacity[cartIdx] && cargoTons[i] > 0) {
            cartOnBoard += cargoTons[i];
            cartElements += Integer.toString(cargoTons[i]) + ",";
            cargoTons[i] = -1; // you need to mark used cargos
        }
    }
    System.out.println(Integer.toString(cartCapacity[cartIdx]) + "->{" + cartElements + "}"); // print one line per cart, not per every cargo
    cartIdx++;
}