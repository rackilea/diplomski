rule "testcase"
   salience 300
    when
        $item : Item(itemTypeId in (Item.ITEM_TYPE_A, Item.ITEM_TYPE_B), targetId < 0)
        not Tegret(targetId == ((long)$item.targetId))
    then
        retract ($item);
end