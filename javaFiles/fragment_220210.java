private boolean matchIdsAndStatuses(List<Item> items, ItemResponse currentItemResponse, StatusValue statusValue) {
    return items.stream()
            .map(ItemBase::getInnerId)
            .map(currentItemResponse.getMapIdsAndStatuses()::get)
            .filter(Objects::nonNull)
            .map(Status::getStatusValue)
            .filter(statusValue::equals)
            .count() == items.size();
}