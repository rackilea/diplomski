final byte[] passwordBytes = "password".getBytes(StandardCharsets.UTF_8);
final byte[] rBytes = "f@ghj!$g".getBytes(StandardCharsets.UTF_8);

digest.update(passwordBytes);
digest.update(rBytes);
byte[] currentHash = digest.digest();

for (int i = 1; i < iterations; i++)
{
    digest.update(currentHash);
    digest.update(rBytes);
    currentHash = digest.digest();
}