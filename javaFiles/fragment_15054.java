ArrayList al = new ArrayList();

// ... add elements skipped...

// now clear it 
int size = al.size();
for (int index = size-1; index >= 0; index--) {
    al.remove(index);
}