FileOutputStream os = new FileOutputStream("revision2.pdf");
byte bb[] = new byte[1028];
InputStream ip = fields.extractRevision("sig2");
int n = 0;
while ((n = ip.read(bb)) > 0)
    os.write(bb, 0, n);
os.close();
ip.close();