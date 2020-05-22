Task task = new Task<Void>() {
        @Override public Void call() {                
            try {
                int i=0;
                do {
                    // **************************                        
                    //doing other stuff here
                    // ************************** 
                    if (pageVLEDEResult.contains("something")) {                           
                        final List <not sure what class this is> fobLstInvalid = obLstInvalid;
                        final List <not sure what class this is> fobLstDataset = obLstDataset;
                        final int fi = i;

                        Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                                obLstInvalid.add((String)obLstDataset.get(fi));    
                            }
                        });
                    }

                    else if (pageVLEDEResult.contains("something else")){
                        if (i!=0){
                            i--;
                        }
                    }

                    updateProgress (i+1, obLstDataset.size());
                    i++;
                } while (i < obLstDataset.size())

            } catch (IOException | FailingHttpStatusCodeException ex) {
                Logger.getLogger(VehicleLicenceExpiryDateEnquirer.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    };