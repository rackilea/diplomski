StringBuilder sb = new StringBuilder("<html>");
    sb.append("<span style='font-family: Serif'>");
    for (String step : stepsArr) {
        sb.append(step).append("<br>");
    }
    sb.append("</span>");