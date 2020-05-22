enum ModifiersEnum {
    COMPOSITE_BENEFITS_TABLE_ROW, 
    TABLE_ROW;
}

public Function<RowBean, RowBean> getRowModifierInstance(ModifiersEnum ratingType, Map<ModifiersEnum, Object> parameters) {
    switch (ratingType)
    {
      case AGE:
        return planSpecificBenefitsRatingTableRowModifier;
      case COMPOSITE_AGE:
        return planSpecificBenefitsRatingTableRowModifier
          .andThen(parameters.get(ModifiersEnum.COMPOSITE_BENEFITS_TABLE_ROW))
          .andThen(parameters.get(ModifiersEnum.TABLE_ROW));
      default:
        return new EmptyRatingTableRowModifier();
    }
}