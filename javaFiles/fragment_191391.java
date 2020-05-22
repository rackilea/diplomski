public Mono<Map<String, Object>> registerService(User user) {
    return userRepository.save(user)
        .map(__ -> {
            Map<String, Object> map = new HashMap<>();
            map.put("status", 1);
            return map;
        });
}