class Comp implements Comparator<Kot>{
     @Override
        public int compare(Kot kot1, Kot kot2) {
            int kotNoCompare = kot1.getKotNo().compareTo(kot2.getKotNo());
            if (kotNoCompare == 0) {
                int productNameCompare = kot1.getProductName().compareTo(kot2.getProductName());
                return productNameCompare;
            }
            return kotNoCompare;
        }
}