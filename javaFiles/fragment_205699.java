boolean found = false;
for(int i = 0; i < keys.size(); i++) {
    if(keys.get(i).equals(key)) {
        vals.set(i, value);
        found = true;
        break;        
    }
if (!found) {
    keys.add(key);
    vals.add(value);
}