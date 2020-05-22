public ListarStatus() {
        ctx = new ClassPathXmlApplicationContext(new String[] {
                "/com/softclear/inventario/test/fitnesse/applicationContext-ListarStatus.xml",
                "applicationContext-dao.xml",
                "applicationContext-hibernate.xml"});

        serv = (ServicioStatus) ctx.getBean("servicioStatus");
    }