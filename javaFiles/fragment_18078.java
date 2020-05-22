void print_rec(List<String>[] tab, int depth, String str) {
    int maxdepth = tab.length - 1;
    for (int i = 0; i < tab[depth].size(); i++) { // number of strings at this depth
        if (depth == maxdepth) {
            System.out.println(str + tab[depth].get(i)); // print line
            // no more lists to go through, print the line
        } else {
            print_rec(tab, depth + 1, str + tab[depth].get(i) + " ");
            // add next entry at this level to str and recurse
        }
    }
    // done with this depth, go back up one
}

void printAll(List<Strings>[] tab) {
    print_rec(tab, 0, "");
}