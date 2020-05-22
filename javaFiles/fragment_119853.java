public String discountPercentage() {
        int actualPrice, dealPrice;
        try {
            actualPrice = Integer.parseInt(actual_price);
            dealPrice = Integer.parseInt(deal_price);
        } catch (NumberFormatException ex) {
            return "Not Available";
        }

        int discount = actualPrice - dealPrice;
        float discountPercentage = ( (float) discount / actualPrice ) * 100;
        return String.format("%.02f", discountPercentage) + "%";
    }