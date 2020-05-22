@Test
@Transactional
public void testReadWithDependencies() {
    assertThat(parentRepo.findAll()).isEmpty();
    assertThat(childRepo.findAll()).isEmpty();

    ParentEntity savedParent1 = parentRepo.save(new ParentEntity("parent1"));
    childRepo.save(new ChildEntity("child1", savedParent1.getId()));

    List<ParentEntity> allParents = parentRepo.findAll();
    assertThat(allParents).hasSize(1);

    // Refresh
    ParentEntity parentEntity = allParents.get(0);
    entityManager.refresh(parentEntity);

    Set<ChildEntity> acutalChildren = parentEntity.getChildren();

    // XXX When the tests are run with @Transactional, this assertion fails.
    assertThat(acutalChildren).isNotNull();

    assertThat(acutalChildren).hasSize(1);
    assertThat(acutalChildren.iterator().next().getName()).isEqualTo("child1");
}