$ cat test.txt
Attack at dawn!

$ hexdump -C test.txt
00000000  41 74 74 61 63 6b 20 61  74 20 64 61 77 6e 21 0a  |Attack at dawn!.|
00000010

# Create private key in PEM format
$ openssl ecparam -name secp256k1 -genkey -noout -out secp256k1-key.pem

$ cat secp256k1-key.pem
-----BEGIN EC PRIVATE KEY-----
MHQCAQEEIO0D5Rjmes/91Nb3dHY9dxmbM7gVfxmB2+OVuLmWMbGXoAcGBSuBBAAK
oUQDQgAEgVNEuirUNCEVdf7nLSBUgU1GXLrtIBeglIbK54s91HlWKOKjk4CkJ3/B
wGAfcYKa+DgJ2IUQSD15K1T/ghM9eQ==
-----END EC PRIVATE KEY-----

# Convert private key to ASN.1/DER format
$ openssl ec -in secp256k1-key.pem -inform PEM -out secp256k1-key.der -outform DER

$ dumpasn1 secp256k1-key.der
  0 116: SEQUENCE {
  2   1:   INTEGER 1
  5  32:   OCTET STRING
       :     ED 03 E5 18 E6 7A CF FD D4 D6 F7 74 76 3D 77 19
       :     9B 33 B8 15 7F 19 81 DB E3 95 B8 B9 96 31 B1 97
 39   7:   [0] {
 41   5:     OBJECT IDENTIFIER secp256k1 (1 3 132 0 10)
       :     }
 48  68:   [1] {
 50  66:     BIT STRING
       :       04 81 53 44 BA 2A D4 34 21 15 75 FE E7 2D 20 54
       :       81 4D 46 5C BA ED 20 17 A0 94 86 CA E7 8B 3D D4
       :       79 56 28 E2 A3 93 80 A4 27 7F C1 C0 60 1F 71 82
       :       9A F8 38 09 D8 85 10 48 3D 79 2B 54 FF 82 13 3D
       :       79
       :     }
       :   }

# Create public key from private key
$ openssl ec -in secp256k1-key.der -inform DER -pubout -out secp256k1-pub.der -outform DER

$ dumpasn1 secp256k1-pub.der
  0  86: SEQUENCE {
  2  16:   SEQUENCE {
  4   7:     OBJECT IDENTIFIER ecPublicKey (1 2 840 10045 2 1)
 13   5:     OBJECT IDENTIFIER secp256k1 (1 3 132 0 10)
       :     }
 20  66:   BIT STRING
       :     04 81 53 44 BA 2A D4 34 21 15 75 FE E7 2D 20 54
       :     81 4D 46 5C BA ED 20 17 A0 94 86 CA E7 8B 3D D4
       :     79 56 28 E2 A3 93 80 A4 27 7F C1 C0 60 1F 71 82
       :     9A F8 38 09 D8 85 10 48 3D 79 2B 54 FF 82 13 3D
       :     79
       :   }

# Sign the message using the private key
$ cat test.txt | openssl dgst -ecdsa-with-SHA1 -sign secp256k1-key.der -keyform DER > test.sig

# Dump the signature as hex
$ hexdump -C test.sig
00000000  30 44 02 20 08 66 c8 f1  6f 15 00 40 8a e2 1b 40  |0D. .f..o..@...@|
00000010  56 28 9c 17 8b ca 64 99  37 dc 35 ad ad 60 18 4d  |V(....d.7.5..`.M|
00000020  63 cf 4a 06 02 20 78 4c  b7 0b a3 ff 4f ce d3 01  |c.J.. xL....O...|
00000030  27 5c 6c ed 06 f0 d7 63  6d c6 be 06 59 e8 c3 a5  |'\l....cm...Y...|
00000040  ce 8a f1 de 01 d5                                 |......|
00000046

# Dump the signature as ASN.1/DER
$ dumpasn1 test.sig
  0  68: SEQUENCE {
  2  32:   INTEGER
       :     08 66 C8 F1 6F 15 00 40 8A E2 1B 40 56 28 9C 17
       :     8B CA 64 99 37 DC 35 AD AD 60 18 4D 63 CF 4A 06
 36  32:   INTEGER
       :     78 4C B7 0B A3 FF 4F CE D3 01 27 5C 6C ED 06 F0
       :     D7 63 6D C6 BE 06 59 E8 C3 A5 CE 8A F1 DE 01 D5
       :   }