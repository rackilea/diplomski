Minion m;
for (int i = 0; i < minionArray.size(); i++) { // I'm assuming minionArray is a List type
    m = minionArray.get(i);
    m.update();
    if (m.isDead() == true) {

        minionArray.remove(i);
        i--; // set the pointer back by 1 so you don't skip updating the next minion in the list.
    }
}