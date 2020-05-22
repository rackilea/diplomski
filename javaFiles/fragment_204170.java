container.getManufacturerList().stream()
    .filter(manufacturer ->
        manufacturer.getModelList().stream().anyMatch(model ->
            model.getTrimList().stream().anyMatch(trim ->
                trim.getTrimType().equals("sunroof"))))
    .collect(Collectors.toList());