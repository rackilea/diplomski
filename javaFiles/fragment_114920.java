String[] cmd = {
            "/system/bin/sh",
            "-c",
            "logcat -d | grep \"ActivityManager: ANR\" -A 38"
        };

        Process process = Runtime.getRuntime().exec(cmd);