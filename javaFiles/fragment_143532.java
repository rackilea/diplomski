char start = 'Q';
char end = 'K';
char stopHere = end++;

while ( start != stopHere ){
    System.out.println(start);
    if( start == 'Z' ){
        start = '0';
    }
    else if( start == '9' ){
        start = 'A';
    }
    else{
        start++;
    }
}