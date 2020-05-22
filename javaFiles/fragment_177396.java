public void readFile() throws IOException {

    Scanner read = new Scanner(
        new File(
            "/home/user/MyProjects/java-recruitment-task/parserproject/src/main/resources/access.txt"));

    while (read.hasNext()) { //checks if there is a valid token

        String string = read.nextLine();
        System.out.println(string);

        Scanner readFileByLine = new Scanner(string);

        while (readFileByLine.hasNext()) { //checks valid token if not then goes out of loop
            String[] split = readFileByLine.nextLine().split("\\|");
            LogBean logBean = new LogBean();

            logBean.setDateTime(LocalDateTime.parse(split[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
            logBean.setIp_address(split[1]);
            logBean.setRequest(split[2]);
            logBean.setStatus(split[3]);
            logBean.setUserAgent(split[4]);
        }
        logbeanRepository.save(logBean);
    }

}