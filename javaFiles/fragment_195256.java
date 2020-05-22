for(int i=0;i<figuri.size();i++)
    {
        gg.setColor(culoare[((Integer)culori.get(i)).intValue()]);
        gg.draw((Shape)figuri.elementAt(i));

        if (culori.get(i)!=null){
            gg.setColor(culoare[((Integer)culori.get(i)).intValue()]);
            gg.fill((Shape)figuri.elementAt(i));
        }
    }