PropPanel ppun = new PropPanel (user.name) {
    public void update () {
        user.setName (textfield.getText ());
    }
}

PropPanel ppun = new PropPanel (user.age) {
    public void update () {
        user.setAge (Integer.parseInt (textfield.getText ()));
    }
}