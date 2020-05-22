public class QuantityCatalogue {
        private ArrayList<String> items;

            //this method helps us change the value of field items
        public void setItems(ArrayList<String> items) {
            this.items = items;
        }

          .....
    }

    public class Buy extends QuantityCatalogue {
        public void someMethod(ArrayList<String> items) {
            //call setItems method of superclass
            this.setItems(items);
        }
    }