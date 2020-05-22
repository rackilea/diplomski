MyCustomComparator c = new MyCustomComparator();

for(int i=0; i < tab.size()-1; i++){
    if(!c.compare(tab[i], tab[i+1])){
        throw new Exception("Not sorted");
    }
}