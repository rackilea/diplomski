public class Icb_Cart {
    private  Icb_Model model = new Icb_Model();

    public void addToCart() throws IOException {                 
        ...
        switch(data) {
        case "nb1":
                model.setPrice(29995);
                break;

        case "nb2":
            model.setPrice(24995);
                break;

            }
        model.setTotalPrice(model.getPrice() + model.getTotalPrice());
        JOptionPane.showMessageDialog(null, model.getTotalPrice());
        ...
}