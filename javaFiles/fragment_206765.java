for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : appinfolist) {
        TaskObject runningtask = new TaskObject();
        String ringgo = new String();

        ringgo = runningAppProcessInfo.processName.toLowerCase().trim();
        if (!ringgo.equals("system")){
            if (ringgo.length()>12){
            runningtask.setPid(runningAppProcessInfo.pid);
            runningtask.setProcessName(ringgo.substring(12).substring(0,1).toUpperCase()+ringgo.substring(13));
            adapter.addTask(runningtask);}
            else{
                runningtask.setPid(runningAppProcessInfo.pid);
                runningtask.setProcessName(ringgo.substring(0,1).toUpperCase()+ringgo.substring(1));
                adapter.addTask(runningtask);
            }
        }

    }
}