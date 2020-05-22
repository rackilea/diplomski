Enemy [] enemy = new Enemy[3];
enemy[0] = new Enemy();
enemy[1] = new Enemy();
enemy[2] = new Enemy();

enemy[0].adjustLife(int someDelta); // to adjust the life of this enemy
enemy[0].getLife(); // to get the life points
enemy[0].isDead(); // to check if it's dead
enemy[0].getPosition(); // to retrieve the position