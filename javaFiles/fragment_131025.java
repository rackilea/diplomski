boolean found = false;
int position = 0, oldPosition = 0;
int a, b, count = 0;

while(!found) {
    if(c.charAt(position) == '\n') {
        count++;
        if(count == 1) {
            a = Integer.parseInt(c.substring(oldPosition, position));
            oldPosition = position+1;
        }
        if(count == 2) {
            b = Integer.parseInt(c.substring(oldPosition, position));
            found = true;
        }
    }
    position++;
}