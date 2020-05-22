String formatNames [] = interviewNames.split(",");
    String formatTiming [] = timing.split("[|]");

    System.out.println("formatNames :"+formatNames.length);
    System.out.println("formatTiming :"+formatTiming.length);
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<formatNames.length;i++){
        if (i>0) sb.append(" | ");
        sb.append(formatNames[i]+" -- "+formatTiming[i]);
    }
    System.out.println(sb.toString());