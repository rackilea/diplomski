public interface GroupA { }  //empty marker interface
public interface GroupB { }


@DTOEntityFieldsEmpty(groups=GroupA.class)
@DTOEntityFieldsNotEmpty(groups=GroupB.class)
public class EntityDTO {
    ....
} 


public void updateData(
       @RequestBody @Validated({ GroupA.class }) EntityDTO dto){
   ...
}