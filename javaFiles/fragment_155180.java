DoubleSummaryStatistics stats = products.stream()
            .mapToDouble(this::timeConsumingCalculateRating)
            .filter(rating -> rating > 0.0D)
            .summaryStatistics();
long count = stats.getCount();
double averageRating = stats.getAverage();