.class super StringArray

.field static final private stringArray [Ljava/lang/String;

.const [1] = String 'AAA'
.const [2] = String 'AAB'
.const [3] = String 'AAC'

.method static <clinit> : ()V
    iconst_5
    anewarray java/lang/String
    astore_0
    aload_0
    iconst_0
    ldc [1]
    aastore
    aload_0
    iconst_1
    ldc [2]
    aastore
    aload_0
    iconst_2
    ldc [1]
    aastore
    aload_0
    iconst_3
    ldc [3]
    aastore
    aload_0
    iconst_4
    ldc [1]
    aastore
    aload_0
    putstatic StringArray stringArray [Ljava/lang/String;
    return
.end method