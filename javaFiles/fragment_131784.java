Callback<TableColumn<MyCellData, Integer>, TableCell<MyCellData, Integer>> c2 = new Callback<TableColumn<MyCellData, Integer>, TableCell<MyCellData, Integer>>() {
            @Override
            public TableCell<MyCellData, Integer> call(TableColumn<MyCellData, Integer> param) {
                return new MyCell<Integer>();
            }
        };