public static DefaultComboBoxModel<String> getModel(DataType dataType)
{
    String[] items = (String[]) DataManager.getDataTable(dataType)
                                           .getUniqueStringMap()
                                           .keySet().toArray();

    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(items);
    return model;
}