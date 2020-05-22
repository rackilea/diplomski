class SiteRepository { 
   private final MultiMap<Site> sites = new MultiMap<>();
   public final AbstractMap<String, Site> byName = sites.addIndex((site)->site.name);
   public final AbstractMap<Integer,Site> byId = sites.addIndex((site)->site.id);
   public final AbstractMap<String,List<Site>> byRating = sites.addMultiIndex((Site site)->site.rating);
   public void add(Site s) { sites.add(s); }
}

SiteRepository repo = new SiteRepository();
repo.add(...);
Site site = repo.byId.get(1234);
repo.byId.forEach((Integer id, Site s) -> System.err.printf("   %s => %s\n", id, s));