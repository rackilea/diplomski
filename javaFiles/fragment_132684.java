boolean flag = false;
while ((lineRead = br.readLine()) != null) {
    if (lineRead.matches(".*\\bTrue\\b.*")) {
        flag = true;
    }
    else if (lineRead.matches(".*\\bFalse\\b.*")) {
        if (flag) {
            System.out.println(lineRead);
            flag = false;
        }
    }
}