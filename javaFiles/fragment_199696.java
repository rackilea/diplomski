try {
    Process p = Runtime
                    .getRuntime()
                    .exec("cmd /c start cmd.exe /K \"dir && ping localhost && echo end\"");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }