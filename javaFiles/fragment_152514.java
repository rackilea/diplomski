JsonObject sites = element.getAsJsonObject();

JsonObject site1 = sites.getAsJsonObject("1");

JsonObject clust1 = site1.getAsJsonObject("CLUST");

site1.remove("CLUST");

site1.add("NEWCLUST", clust1);