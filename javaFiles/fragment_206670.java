String str = "This is a test string";
int len1 = str.length();
int hash_str[] = new int[256];

for (int i = 0; i < len1; i++) {
    int index = str.charAt(i);
    hash_str[index]++;
    System.out.println( "index - " + index ", val " + hash_str[index] );
}

for( int x = ' '; x < '~'; x++ ) {
   System.out.println( x + ": " + ((char)x) + " -- " + hash_str[x] );
}