@Test
public void bothValuesShouldBePresent() {
    List lt1 = new ArrayList();
    lt1.add(0);
    lt1.add(1);
    List lt2 = new ArrayList();

    List fakeGetItems = new ArrayList() {{ add(new HashMap<String, Integer>() {{ put("item", 0); }}); add(new HashMap<String, Integer>() {{ put("item", 1); }} ); }};

    for (Object a : fakeGetItems) {
     HashMap b = (HashMap)a;
     lt2.add(b.get("item"));
    }

    assertThat(lt2, hasItems(lt1.toArray(new Integer[lt1.size()])));
}