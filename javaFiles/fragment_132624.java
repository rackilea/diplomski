public static <T> Callback<TableColumn<T, Void>, TableCell<T, Void>> cellFactory(final List<?> list) {
    return c -> new TableCell<T, Void>() {

        @Override
        public void updateIndex(int i) {
            super.updateIndex(i);
            setText(isEmpty() ? "" : Objects.toString(list.get(i), ""));
        }

    };
}