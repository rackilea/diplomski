int end = isdown ? iniY - endY : dy;
int direction = isdown ? -1 : +1;

for(int i = 0; i <= end; i++) {
    int y = iniY + direction * i;
    …
}