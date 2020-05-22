final Phaser phaser = new Phaser(1);

    doNotify()
        phaser.arrive();  // increase phase

    doWait()
        int phase = phaser.getPhase();
        phaser.awaitAdvance( phase );   // await phase change