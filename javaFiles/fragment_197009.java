interface InventoryVisitor{
    onGrenade(theGrenade);
    onDefaultItem(theItem);
}

class DefaultItem{
    visit(visitor){visitor.onDefaultItem(this);}
}

class Grenade extends DefaultItem{
    visit(visitor){visitor.onGrenade(this);}
}