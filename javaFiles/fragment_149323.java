rentals.stream().collect(Collectors.groupingBy(r -> {
    if (!r.isRestricted()) {
        return RentalClassification.UNRESTRICTED;
    }
    if (r.isRestricted() && r.getDueDate().isBefore(new DateTime())) {
        return RentalClassification.OVERDUE;
    }
    // and so on
}));