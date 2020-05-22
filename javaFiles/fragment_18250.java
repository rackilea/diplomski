Sourcerer sourcer = new Sourcerer();
sourcer.getHealth(); // this is a member of the object just created;
sourcer.enemy;  // is a list of Enemy type objects
                // this list is a member of the sourcer object

for(Enemy enemy : sourcer.enemy) {
      enemy; //is an object in the list
            //this object should not be sourcer object (see below)
}

sourcer.enemy.add(sourcer); //is valid but will make a really big mess
                            //so make sure you never do this.