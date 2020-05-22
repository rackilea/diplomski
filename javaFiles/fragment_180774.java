groupName.setCellValueFactory(data->{
           Student student = data.getValue();
           String strGroupName = "";// calculate group name for...
           return new ReadOnlyStringWrapper(strGroupName);
        }
    );