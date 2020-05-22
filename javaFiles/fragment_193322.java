arrayListCatalogo.add(new setTextViewCatalogue(getResources()
                          .getString(R.string.codice_arancione), 
                           getResources()
                           .getString(R.string.sfumature_di_arancione), 
                           getResources()
                           .getString(R.string.codice_arancione), new ClickHandler(){
                               @Override
                               void onClick(){
                                   //Your action
                               }
                           }));
    //Do this every time you call "add()"