List<ProfessorEntity> list = getEntityList(new EntityCreator<ProfessorEntity>() {
    @Override
    public ProfessorEntity create(int index) {
        return createProfessorEntity(i);
    }
}, 10);