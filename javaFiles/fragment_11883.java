public static void main(String[] args) {
        String str = "REPLY(MSGID,15,ABC024049364194,SERVICE,10,CREATE,...)";
        String code = str.split(",")[2];
        System.out.println(code);

    }