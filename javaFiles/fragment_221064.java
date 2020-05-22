if (comparison > 0) { // newItem comes BEFORE current
                if (current.getPrevious() != null) { 
                    current.getPrevious().setNextItem(newItem); 
                    newItem.setPreviousItem(current.getPrevious()); 
                    newItem.setNextItem(current); 
                    current.setPreviousItem(newItem); 
                    // return when element is added successfully