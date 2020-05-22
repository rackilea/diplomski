RefreshButton.setOnAction(event->{             
                    ModelBrBuilding buildin= new ModelBrBuilding();                                             
                    int i=tableBuilding.getSelectionModel().getSelectedIndex();                    
                    buildin.setBranchName(old);

                    tableBuilding.getItems().set(i, buildin);               
                });