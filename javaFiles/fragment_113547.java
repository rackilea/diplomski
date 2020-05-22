StringBuilder sb = new StringBuilder();
for (int i = 0; i < args.length; i++){
    sb.append(args[i]);
    if(i != (args.length - 1)) {
        sb.append('+');
    }
}

String allArgs = sb.toString().trim();