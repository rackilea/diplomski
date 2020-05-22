public int compareTo(Question q) {
    if(vote>q.vote) {
        return -1;
    } else if (vote<q.vote){
        return 1;
    } else {
        return 0;
    }
}