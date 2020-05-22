public int compare(ProjectService o1, ProjectService o2) {
    Set<Category> o1CategorySet = o1.getCategories();
    Set<Category> o2CategorySet = o2.getCategories();
    int categoryMatch = 0;
    double matchQuality = 0.0;

    if ((o1CategorySet != null) && (o2CategorySet != null)) {
        for (Category o1Category : o1CategorySet) {
            for (Category o2Category : o2CategorySet) {
                int match = o1Category.getName().compareTo(o2Category.getName());
                if (match == 0) {
                    categoryMatch++;
                } else {
                    categoryMatch--;
                }
            }
        }
    }

    if (categoryMatch == 0) {
        matchQuality++;
    } else {
        matchQuality--;
    }

    int scaleMatch = o1.getDifficultyScale().getEstimation().compareTo(o2.getDifficultyScale().getEstimation());

    if (scaleMatch == 0) {
        matchQuality++;
    } else {
        matchQuality--;
    }

    int amountMatch = o1.getAmount().compareTo(o2.getAmount());

    if (amountMatch == 0) {
        matchQuality++;
    } else {
        matchQuality--;
    }

    return (int) matchQuality;
}