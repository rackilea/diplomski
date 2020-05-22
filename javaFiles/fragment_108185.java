public void updateMyEntity(MyEntity updateableMyEntity);

    // load does not hit the database
    MyEntity myEntity = (MyEntity) session.load(MyEntity.class, updateableMyEntity.getId());

    BeanUtils.copyProperties(myEntity, updateableMyEntity);

}