ALOAD 1
CHECKCAST java/lang/Integer                             // This is now ok
INVOKEVIRTUAL java/lang/Integer.intValue ()I            // Unbox as an Integer
I2B                                                     // Convert to byte
INVOKESTATIC java/lang/Byte.valueOf (B)Ljava/lang/Byte; // Box as a Byte
ASTORE 2