public void deleteAutomobili(Integer automobilId) {
            if(automobilMap.containsKey(automobilId))
                 automobilMap.remove(automobilId);
            else {
               // notify that resource doesn't exists
            }
    }