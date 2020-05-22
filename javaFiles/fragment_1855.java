import ibdb.model.mappers.LongArrayType;
import ibdb.model.mappers.ShortArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.MappedSuperclass;

@TypeDefs({
        @TypeDef(
                name = "long-array",
                typeClass = LongArrayType.class
        ),
        @TypeDef(
                name = "short-array",
                typeClass = ShortArrayType.class
        )
})
@MappedSuperclass
public class DaoConfig {
}