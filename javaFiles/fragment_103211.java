for (int i = 0; i < partsModelMasterList.size(); i++) {
        PartsModel partsModel = partsModelMasterList.get(i);

        // compare model
        if (filterModel != null && !partsModel.getPartModel().equalsIgnoreCase(filterModel)) {
            continue;
        }
        // compare product name
        else if (filterProduct != null && !partsModel.getPartName().equalsIgnoreCase(filterProduct)) {
            continue;
        }
        // compare filterDescription
        else if (filterDescription != null && !partsModel.getPartSpecs().contains(filterDescription)) {
            continue;
        }
        partsModelList.add(partsModel);
    }