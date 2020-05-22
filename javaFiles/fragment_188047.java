@Test
public void test() {
    Assert.assertFalse(CollectionUtils.contains(Arrays.asList(1,2,3,4), Arrays.asList(2,3,4,5)));
    Assert.assertTrue(CollectionUtils.contains(Arrays.asList(1,2,3,4), Arrays.asList(2,3,4)));
    Assert.assertTrue(CollectionUtils.contains(Arrays.asList(1,2,3,4), Arrays.asList(2,4)));
    Assert.assertTrue(CollectionUtils.contains(Arrays.asList(1,2,3,4,1,2,3,4), Arrays.asList(3,4,2)));
    Assert.assertFalse(CollectionUtils.contains(Arrays.asList(1,2,3,4), Arrays.asList(2,3,4,5,6)));
}