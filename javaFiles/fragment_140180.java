Map<String, ValueObject> map1 = new LinkedHashMap<>();


for (i = 1; i < (NumberOfItems + 1); i++)
{
    ValueObject vo = new ValueObject();
    vo.setAttr1("a1");
    vo.setAttr2("a2");
    vo.setAttr3("a3");
    ...
    ...
    vo.setAttr25("a25");

    map1.put("item"+i,vo);
}