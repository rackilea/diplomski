FileLock fileLock;

@Before
public void setUp() throws Exception {
    File file = new File("d:/test");
    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
    FileChannel channel = randomAccessFile.getChannel();
    fileLock = channel.tryLock();

}

@After
public void tearDown() throws Exception {
    fileLock.release();
}

@Test
public void testDelete() {
    File tempFile = new File("d:/test");
    Boolean resutl = tempFile.delete();

    assertFalse(resutl);
}