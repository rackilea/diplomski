String seedCode = "yard impulse luxury drive today throw farm pepper survey wreck glass federal";

// BitcoinJ
DeterministicSeed seed = new DeterministicSeed(seedCode, null, "", 1409478661L);
DeterministicKeyChain chain = DeterministicKeyChain.builder().seed(seed).build();
List<ChildNumber> keyPath = HDUtils.parsePath("M/44H/60H/0H/0/0");
DeterministicKey key = chain.getKeyByPath(keyPath, true);
BigInteger privKey = key.getPrivKey();

// Web3j
Credentials credentials = Credentials.create(privKey.toString(16));
System.out.println(credentials.getAddress());