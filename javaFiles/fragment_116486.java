public void run(){
    setSize(800, 600);

    for(int i=0; i<= 30; i++){
        elips el = new elips();
        el.setFilled(true);
        el.setColor(Color.RED);
        elipsler.add(el);
        add(el);
    }

    while(!stopthat){
        // now you can do stuff here that will not be delayed by the ellipse cooldowns
        // neither will it become part of the ellipse cooldowns 
        for(int i=0; i< elipsler.size() -1; i++){
            elipsler.get(i).cdRemove();


            if(elipsler.get(i).canRemove == true){
                remove(elipsler.get(i));
                elipsler.remove(i);
                elips el = new elips();
                el.setFilled(true);

                add(el);
                elipsler.add(el);
            }
        }
    }
}