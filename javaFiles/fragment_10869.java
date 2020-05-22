Collection<User> males = Collections2.filter(users, new Predicate<User>() {
    @Override
    public boolean apply(User user) {
        return user.getSex().equals("Male");
    }
});