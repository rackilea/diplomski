import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class EntityMapperTest {

    private EntityMapperImpl sut;

    @Before
    public void setup() {
        sut = new EntityMapperImpl();
    }

    @Test
    public void shouldMapEntityToDto() {
        // given
        AnEntity entity = new AnEntity();
        entity.setId(42);

        // when
        ADto aDto = sut.toDto(entity);

        // then
        assertThat(aDto)
            .hasFieldOrPropertyWithValue("id", 42);
    }
}