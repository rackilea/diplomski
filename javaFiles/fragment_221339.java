if(addDream.isPressed() && lucidbtn.isChecked()) {
    carnet.setText(editDream.getText().toString());
    carnet.setLucid(1);
    cn.insertNoteReve(carnet);
    editDream.setText("");
    xp = exp.xpUp(wild.isChecked() ? 70 : 30);
    user.setExperience(xp);
    userDao.expUp(user);
}