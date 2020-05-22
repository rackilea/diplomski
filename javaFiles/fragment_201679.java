byte []  header= {   0x2e, 0x73, 0x6e, 0x64,
                      0x0,  0x0,  0x0,  24,
                      -1,  -1,    -1,   -1,
                      0,   0,     0,    1,
                      0,   0,     0x1f, 0x40,
                      0,   0,     0,    1 };
 FileOutputStream out = new FileOutputStream(file);
 out.write(header);