public ArrayList<TempClient> getResortedHighscores(ArrayList<TempClient> list) {
    return Collections.sort(list, new Comparator<TempClient>(){
        public int compare(TempClient o1, TempClient o2){
            return o1.getRatio() - o2.getRatio();
        }
    });
}