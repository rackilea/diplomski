class MyItem extends Item {

    public MyItem (Item pxFilterItem) {
        super();
        setColCode(pxFilterItem.getColCode());
        setColHeader(pxFilterItem.getColHeader());
        setCondition(pxFilterItem.getCondition());
        setJsonCls(pxFilterItem.getJsonCls());
        setJsonValue(pxFilterItem.getJsonValue());
        setValue(pxFilterItem.getValue());
    }

    public String getSqlColumn(){
        return mappingWhere((String) getColCode());
    }

    public String getSqlOperator(){
        return conditionOperator(getCondition());
    }

    public Object getSqlValue(){
        return conditionValue(getCondition(), getValue());
    }
}