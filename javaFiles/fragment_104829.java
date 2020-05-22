interface SimilarityComparator<T, D> {
    D getSimilarityLevel(T a, T b);
}

class LocationDistanceSimilarityComparator implements SimilarityComparator<Location, Distance> { 
    ... 
}

class LocationNameSimilarityComparator implements SimilarityComparator<Location, NameDifference> { 
    ... 
}