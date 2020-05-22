Child child = new Child();
...

ParentOne parentOne = new ParentOne();
ParentTwo parentTwo = new ParentTwo();
...

parentOne.addChild(child);
parentTwo.addChild(child);

parentOneRepository.save(parentOne);