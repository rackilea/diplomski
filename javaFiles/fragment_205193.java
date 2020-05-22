int main(int argc, char* argv[])
{
  byte key[] = "aaaaaaaaaaaaaaaa";
  ECB_Mode<AES>::Encryption enc(key, 16);
  string result;

  StringSource ss(string("hello"), true,
                  new StreamTransformationFilter(enc,
                       new Base64Encoder(
                           new StringSink(result))));

  cout << result << endl;

  return 0;
}