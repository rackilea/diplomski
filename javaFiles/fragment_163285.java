WikipediaTokenizer x = wtt.testSimple();
logger.info(x.hasAttributes());
x.reset();
while (x.incrementToken() == true) {
    logger.info("Token found!");
}
x.end();
x.close();