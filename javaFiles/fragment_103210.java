for (int i = 0; i < partsModelMasterList.size(); i++) {
        PartsModel partsModel = partsModelMasterList.get(i);

        // compare model
        if (filterModel == null || !partsModel.getPartModel().equalsIgnoreCase(filterModel)) {
            continue;
        }
        // [...] Other two conditions removed for brevity

        partsModelList.add(partsModel);
    }