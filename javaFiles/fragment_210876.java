ApplicationContext context = new ClassPathXmlApplicationContext("BeanFactory.xml");
        IBackup dataWriterObj = (IBackup) context.getBean("writeBackupHDFS");
        Name nameBean = (Name) context.getBean("nameBean");
     //   backup backup = new backup();
        nameBean.setNickName("Abbey");
        String result = dataWriterObj.read("Ankur", "Bahre");
    System.out.println(result);