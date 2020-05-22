public class ChainBuilder extends MainChain {

    private long index;
    private long currentTimeMillis;
    private long data;
    private int difficulty;
    private String pszTimeStamp;
    private String previousBlockHash;
    private String currentHash;
    private String genesisHash;

    public long Nonce; //Nonce cannot be be static, otherwise it will cause issues if more than one object is created.
    public static long startTime;

.......
public void miner(long index, long currentTimeMillis, long data, long _Nonce /*You cannot use Nonce here*/, String previousBlockHash, int difficulty) throws InterruptedException {
        this.index = index;
        this.currentTimeMillis = currentTimeMillis;
        this.pszTimeStamp = pszTimeStamp;
        this.Nonce = _Nonce; /*In this scope, Nonce refers to the local variable, and this.Nonce refers to the class variable. 
                            If you use Nonce in this scope, then the class variable will not be changed.*/
        this.previousBlockHash = previousBlockHash;
        this.difficulty = difficulty;
        this.data = data;
        boolean iterator = true;
        String blockHeader = (index + currentTimeMillis + data + Nonce + previousBlockHash + difficulty);
        String hash = SHA256.generateHash(blockHeader);
        startTime = System.nanoTime();
        TimeUnit.SECONDS.sleep(2);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long endTime = System.nanoTime();
                long deltaN = endTime - startTime;
                //long deltaS = (deltaN / 1_000_000_000);
                long hashRate = (1_000_000_000 * Nonce / deltaN); /*calculate the hashRate directly, because if deltaN < 1_000_000_000, 
                                                                then deltaS will be 0, giving a divide by zero error.*/
                System.out.println("Current hash rate: " + hashRate + " " + "hash/s");
            }
        }, 0, 3000);
        while (iterator) {
            blockHeader = (index + currentTimeMillis + data + Nonce + previousBlockHash + difficulty);
            hash = SHA256.generateHash(blockHeader);
            if (difficulty == 1) {

                if (!hash.startsWith("0")) {
                    Nonce++;
                } else {
                    System.out.println("Hash found!");
                    timer.cancel();
.......