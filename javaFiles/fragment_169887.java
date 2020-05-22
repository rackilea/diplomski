@Override
public void createUser(UserDetails user) {// TODO Auto-generated method stub
    repo.save((User) user);
}

@Override
public void updateUser(UserDetails user) {// TODO Auto-generated method stub
    repo.save((User) user);
}