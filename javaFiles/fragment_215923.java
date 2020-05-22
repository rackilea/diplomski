Comparator<Enemy> comparator = new Comparator<Enemy>() {

    @Override
    public int compare(Enemy e1, Enemy e2) {
        if (e1.getY() > e2.getY())
            return 1;
        else if (e1.getY() < e2.getY())
            return -1;
        return 0;
    }

};
Collections.sort(EnemyList, comparator);
for (int i=0; i<EnemyList.size(); i++) {
    EnemyList.get(i).setZIndex(i);
}
enemyLayer.sortChildren();