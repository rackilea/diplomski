@Captor
private ArgumentCaptor<Iterable<BlockPos>> captor;

@Test
public void test() {
  ...
  LightPropagator propagator = mock(LightPropagator.class);
  FirstLightProcessor proc = makeProcessor(new TestLightBlockAccessImpl(20), propagator);
  proc.updateSkylightFor(cubePos);

  verify(propagator).propagateLight(any(), captor.capture(), any(), any(), any())
  Iterable<BlockPos> actualValues = 
      captor.getAllValues()
           .stream()
           .flatMap(i -> StreamSupport.stream(i.spliterator(), false))
           .collect(toList()); 
  assertThat(actualValues, containsInAnyOrder(expected.toArray(new BlockPos[0])));
}