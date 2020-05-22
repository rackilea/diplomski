try {
        Process process = Runtime.getRuntime().exec("sqlcmd -E -d \"example\" -Q \"EXEC dbo.procTest;\"");
        process.waitFor();
    } catch (IOException e) {
        // Handler here
    } catch (InterruptedException e) {
        // Handler here
    }