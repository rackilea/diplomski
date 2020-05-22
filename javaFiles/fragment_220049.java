class Entity {
    String end_time
    boolean is_booked
    boolean is_expired
    long slot_id;
    String start_time;
    String username;
}

List<Entity> entities = gson.fromJson(yourJsonAsString), Entity.class);