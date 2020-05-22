int ShopValue = (int)Math.floor(getItemShopValue(removeId, 1, removeSlot));
        String ShopAdd = "";
        if (ShopValue >= 1000 && ShopValue < 1000000) {
            ShopAdd = " (" + Math.floor(ShopValue*.75 / 1000) + "k)";
        } else if (ShopValue >= 100) {
            ShopAdd = " (" + Math.floor(ShopValue*.75 / 1) + " coins)";
        } else if (ShopValue >= 1000000) {
            ShopAdd = " (" + Math.floor(ShopValue*.75 / 1000000) + " million)";
        } else if (ShopValue >= 1000000000) {
            ShopAdd = " (" + Math.floor(ShopValue*.75 / 1000000000) + " billion)";
        }
        c.sM(c.getItems().getItemName(removeId)+": shop will buy for <col=255>"+ShopAdd+"</col> coins");
    }
}