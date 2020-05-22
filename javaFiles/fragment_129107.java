@Select("SELECT 
  a.id             id,
  a.title          title,
  hierarchy.id     hierarchy_id,
  hierarchy.author hierarchy_author
  FROM attachments a
  JOIN attachments hierarchy on hierarchy.id = a.parent_id
  WHERE a.id = #{attach_id}")
@ConstructorArgs(value = {
        @Arg(column = "id", javaType = int.class),
        @Arg(column = "title", javaType = String.class),
        @Arg(column = "hierarchy_id", javaType = int.class),
        @Arg(column = "hierarchy_author", javaType = String.class)
  })
AttachmentHierarchy findAttachmentHierarchy(@Param(attach_id) int attachId);