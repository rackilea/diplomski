GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
NEW java/lang/StringBuilder
DUP
INVOKESPECIAL java/lang/StringBuilder.<init> ()V
LDC ""
INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
ILOAD 1
INVOKEVIRTUAL java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V