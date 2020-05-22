int points = 5;

if (!map.containsKey(email)){
   points += map.get(email);
}

map.put(email, points);