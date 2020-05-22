List<RestaurantInfo> ll;
for (RestaurantInfo restaurant: restaurants) {
  // If restaurant is from the same city which is present in the map then add restaurant to the existing list, else create new list and add.
  if (map.containsKey(restaurant.cityId)) {
    ll = map.get(restaurant.cityId);
  } else {
    ll = new List<RestaurantInfo>();
  }
  ll.add(restaurant);
  map.put(restaurant.cityId, ll);
}