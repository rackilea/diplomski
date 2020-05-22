@RunWith(MockitoJUnitRunner.class)
public class CacheControlFilterTest {
    @InjectMocks CacheControlFilter cacheControlFilter;
    @Spy MockHttpServletRequest request;
    @Spy MockHttpServletResponse response;
    @Mock FilterChain filterChain;

    // The rest will be roll out very soon!
}