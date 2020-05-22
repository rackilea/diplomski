User u = new User();
Disposable disposable = RxUser.observe(u).subscribe((user) -> {
    // will be called for changes
});

u.setFirstName("hello");