import java.time.LocalTime

try {
    println "[${LocalTime.now()}] Start..."

    def proc = ["/bin/sh", "-c", "sleep 5s && echo 'test'"].execute()

    proc.waitForOrKill(2 * 1000)

    def output = proc.text?.trim()

    println "[${LocalTime.now()}] Output = ${output}"

} catch (IOException e) {
    System.err.println("[${LocalTime.now()}] Process killed before completing!")
} finally {
    println "[${LocalTime.now()}] End..."
}