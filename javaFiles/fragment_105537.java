KeyStore ks = KeyStore.getInstance("JKS");
ks.load(null); // NO INPUTSTREAM HERE
...
ks.setKeyEntry(...); // or .setEntry(...) as desired
...
OutputStream fo = Files.newOutputStream(Path.of("myfile")); // or similar
ks.store(fo,password); fo.close();