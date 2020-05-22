cbTreeView.setCellFactory((TreeView<String> item) -> {

        final CheckBoxTreeCell<String> cell = new CheckBoxTreeCell<>();

        cell.itemProperty().addListener((obs,s,s1)->{
            cell.disableProperty().unbind();
            if(s1!=null && !s1.isEmpty()){
                Wrap wrap=disableList.stream()
                        .filter(w->w.getName().equals(s1))
                        .findFirst().orElse(null);
                if(wrap!=null){
                    cell.disableProperty().bind(wrap.disabledProperty());
                }
            }
        });
        return cell;
    });