import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AServiceTest {

    private EntityMapper mapperMock;

    private ARepository repositoryMock;

    private AService sut;

    @Before
    public void setup() {
        repositoryMock = mock(ARepository.class);
        mapperMock = mock(EntityMapper.class);

        sut = new AService(repositoryMock, mapperMock);
    }

    @Test
    public void shouldReturnResource() {
        // given
        AnEntity mockEntity = mock(AnEntity.class);
        ADto mockDto = mock(ADto.class);

        when(repositoryMock.getEntity(42))
                .thenReturn(mockEntity);
        when(mapperMock.toDto(mockEntity))
                .thenReturn(mockDto);

        // when
        ADto resource = sut.getResource(42);

        // then
        assertThat(resource)
                .isSameAs(mockDto);
    }
}