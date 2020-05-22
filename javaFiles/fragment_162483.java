Process p = Runtime.getRuntime().exec("cmd /c mysqlbackup.bat", null, new File("C:\\MySQLBackups"));            
        p.waitFor();

        wait.dispose();

        MessageService.showMessageDialog(MessageService.BACKUP_SUCCESSFUL, "Successful", "info");