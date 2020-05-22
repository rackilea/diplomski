tc_ma_sell_amount.setCellFactory(param -> {
            return new TableCell<ConversionDeals, BigDecimal>(){
                @Override
                protected void updateItem(BigDecimal item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty || item == null){
                        setText("");
                    } else {
                        setText(df.format(item));
                    }
                }
            };
        });