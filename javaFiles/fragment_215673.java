public class MyTestUnit {

    public enum Message{
        NULL_REQUEST("Null Request"),
        INVALID_NUMBER_OF_REQUESTS("Invalid number of requests");

        Message(String msg){
            this.msg = msg;
        }

        private final String msg;

        public String getMsg() {
            return msg;
        }

        @Override
        public String toString() {
            return msg;
        }


    }

    @Test
    public void test(){
        String x = Message.INVALID_NUMBER_OF_REQUESTS.toString();
        Assert.assertEquals(x, "actual value" );
    }

}