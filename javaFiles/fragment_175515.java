for (int i = 0; i < model.getEmbedded().getWpTerms().size(); i++) {
        for (int j=0;j<model.getEmbedded().getWpTerms().get(i).size();j++){

            Log.e("DATA",model.getEmbedded().getWpTerms().get(i).get(j).getName());
        }
    }