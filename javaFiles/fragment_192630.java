clusters = filteredClusters.union(newClusterRDD).coalesce(2).cache();
        similarities = similarities.filter(tuple -> 
                (tuple._1()._1().getId() != MOST_SIMILAR.value()._1()) && 
                (tuple._1()._1().getId() != MOST_SIMILAR.value()._2()) && 
                (tuple._1()._2().getId() != MOST_SIMILAR.value()._1()) && 
                (tuple._1()._2().getId() != MOST_SIMILAR.value()._2()))
                .union(newSimilarities).coalesce(4).cache();
        if ((loops++) >= 50)
        {
            clusters.checkpoint();
            clusters.count();
            similarities.checkpoint();
            loops = 0;
        }