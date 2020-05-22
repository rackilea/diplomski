for (User user : _usrs) {
    if (user instanceof Manager) {
        Manager mng = (Manager) user;
        mng.manage(); // or whatever managers do that employees don't
    } else { //if no other classes extend the User class
        Employee emp = (Employee) user;
        emp.work(); // or whatever employees do that managers don't :P
    }
}