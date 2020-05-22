public CounselInfoEntity editTo(CounselInfoEntity model)
{
    CounselInfoEntity entity = id(model.getId());

    List<? extends Attribute<CounselInfoEntity, ?>> editAttrs = Lists.<Attribute<CounselInfoEntity, ?>>newArrayList(CounselInfoEntity_.name,
    CounselInfoEntity_.address,
    CounselInfoEntity_.education,
    CounselInfoEntity_.phone,
    CounselInfoEntity_.QQ,
    CounselInfoEntity_.remark,
    CounselInfoEntity_.school,
    CounselInfoEntity_.age,
    CounselInfoEntity_.sex);

    BeanHelper.merge(entity, model, BeanHelper.skipNullOrEmpty(model, editAttrs));

    if (model.getClassIntention() != null)
    {                           
        entity.setClassIntention(classService.id(model.getClassIntention().getId()));
    }

    return entity;
}