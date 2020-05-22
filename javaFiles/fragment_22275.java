public class TestMapperImpl implements TestMapper {

    @Override
    public Entity toEntity(Dto dto) {
        if ( dto == null ) {
            return null;
        }

        Entity entity = new Entity();

        entity.ab = toAB( dto );

        return entity;
    }

    @Override
    public AB toAB(Dto dto) {
        if ( dto == null ) {
            return null;
        }

        AB aB = new AB();

        Long id = dtoBId( dto );
        if ( id != null ) {
            aB.bId = id;
        }
        Long id1 = dtoAId( dto );
        if ( id1 != null ) {
            aB.aId = id1;
        }

        return aB;
    }

    private Long dtoBId(Dto dto) {
        if ( dto == null ) {
            return null;
        }
        DtoB b = dto.b;
        if ( b == null ) {
            return null;
        }
        Long id = b.id;
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long dtoAId(Dto dto) {
        if ( dto == null ) {
            return null;
        }
        DtoA a = dto.a;
        if ( a == null ) {
            return null;
        }
        Long id = a.id;
        if ( id == null ) {
            return null;
        }
        return id;
    }
}