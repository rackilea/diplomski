Collection<ObjectG> objectsG = collectG(objectA); // extracted method

for (ObjectG objectG : objectsG) {
    objectG.setSomething("BlaBla");

    if (objectG.getOjectH() != null && objectG.getOjectH().getObjectI() != null) {
        for (ObjectI objectI : objectG.getOjectH().getObjectI()) {
            externalVariable2.add(objectI);
            ObjectJ objectJ = getRelevantOjectJ(objectA.getId(), objectI.getId());
            objectI.setObjectJ(objectJ);
        }
    }