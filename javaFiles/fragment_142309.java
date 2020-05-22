public long getHash(String input)
{
int hash=<any prime number>;
for (int i=0; i < input.length(); i++) {
    hash = hash*<any large prime_number>+charAt(i);
}
}