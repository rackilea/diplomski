// Use the normal try/finally for closing reliably
InputStreamReader reader = new InputStreamReader(fis, "ASCII");

Nt.Builder builder = Nt.newBuilder();
TextFormat.merge(reader, builder);
Nt nt = builder.build();