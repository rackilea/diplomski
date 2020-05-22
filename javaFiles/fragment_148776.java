try {
    println "[${LocalTime.now()}] Start..."
    def proc =["/bin/sh", "-c", "./commandx"].execute()
    proc.waitForOrKill(420 * 1000)
    proc.waitForProcessOutput(System.out, System.err)
} catch (IOException e) {
    System.err.println("[${LocalTime.now()}] Process killed before completing! 6")
} finally {
    println "[${LocalTime.now()}] End..."
}