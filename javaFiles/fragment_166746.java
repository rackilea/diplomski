bIter = bullets.iterator();
while(bIter.hasNext()){
    b = bIter.next();           
    mIter = monsters.iterator();
    while(mIter.hasNext()){
        m = mIter.next();
        if(m.getBounds().overlaps(b.getBounds())){
            mIter.remove();
            bIter.remove();
            break; // <-- this is new
        }
    }
}