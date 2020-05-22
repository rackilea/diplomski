@Override
public void update() {
    world.step(1, 1, 1);
    mother.update();
    for (int i = 0; i < viruses.size(); i++) {
        VirusEntity e = viruses.get(i);
        if (e.isRemoved()) {
            viruses.remove(e);
            e.dispose();
            // --v--
            VirusEntity newVirus = new VirusEntity(world, mother, e.getSpawnPosition());
            viruses.add(newVirus);
            // --^--
        } else e.update();
    }
}