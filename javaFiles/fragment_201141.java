private ListCell<Duration> createListCell() {
    return new ListCell<Duration>() {
       @Override
       public void updateItem(Duration item, boolean empty) {
           super.updateItem(item, empty);
           if (empty) {
               setText(null);
           } else {
               if (item == Duration.UNKNOWN) {
                   setText("Stop");
               } else {
                   setText(String.format("%.0f Second", item.toSeconds()));
               }
           }
       }
    };
}