for(Chunk c : chunks){
                if(c.getId() == currentID){
                    currentID++;
                    chunks.remove(c);
                    hasAccess.signalAll(); //signal the readers
                    available = false;
                    return c;
                }
            }