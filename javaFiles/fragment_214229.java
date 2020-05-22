public static void main(String[] args) {
    logger.info("StreamingController testing");
    ApplicationContext ctx = new ClassPathXmlApplicationContext(BEAN_FILE);
    StreamingController obj = (StreamingController) ctx.getBean("streamingController"); 
    obj.streamingMgr.test();
}