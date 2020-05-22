public class IDFilter extends RowFilter<MyModel, Integer> {

        private int id;

        public IDFilter(int id) {
            this.id = id;
        }

        public boolean include(RowFilter.Entry<? extends MyModel, ? extends Integer> entry) {
            MyModel personModel = entry.getModel();
            RowValue value = personModel.getValueAt(entry.getIdentifier());
            if (value.getId() == id) {
                return true;
            }
            return false;
        }

    }