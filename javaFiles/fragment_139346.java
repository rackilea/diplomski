class ParentParentClass {}
class ParentClass extends ParentParentClass {}
class ChildClass extends ParentClass {}
class ChildChildClass extends ChildClass {}

public void simpleTest(Class <? extends ParentClass> myClass) {}