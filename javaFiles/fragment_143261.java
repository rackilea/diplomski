@Override
        public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            System.out.print(listerColumn.getText() + "  ");
            System.out.println(t1);
        }
    });
}