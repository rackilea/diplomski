StringBuilder builder = new StringBuilder();

while ((sCurrentLine = save.readLine()) != null) {
    builder.append(sCurrentLine).append('\n');
}

request.setAttribute("dfTargetDevice", builder.toString());