int listcount=3;
public void splitlist(Atom[] args){
    Vector v=new Vector();
    for(int i=0;i<listcount;i++){ //create vectors:
        v.add(new Vector());
    }
    for(int i=0; i<args.length;i++){//populate vectors: 
        int mod=i%listcount;
        ((Vector)v.get(mod)).add(args[i]); //<<<error here: array required, but java.util.Vector found
    }
    for(int i=0;i<listcount;i++){//output vectors:
        outlet(i,toAtom(v.get(i)));
    }
}